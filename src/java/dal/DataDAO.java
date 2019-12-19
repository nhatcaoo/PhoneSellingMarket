/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Model.CartModel;
import Model.CatalogueModel;
import Model.ProductModel;
import Model.UserModel;
import Query.Query;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beloyten
 */
public class DataDAO {

    Query query = new Query();
    
            
             public ArrayList<CatalogueModel> getCatalogue() throws Exception {
        ArrayList<CatalogueModel> prs = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement pre = con.prepareStatement(query.Show_Catalogue);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                prs.add(new CatalogueModel(id, name));
            }

        } catch (SQLException ex) {

            Logger.getLogger(DataDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return prs;
    }
    public ArrayList<ProductModel> getProduct(int i) throws Exception {
        ArrayList<ProductModel> list = new ArrayList();
        String sql = "  WITH TblCte as (SELECT  *,ROW_NUMBER() OVER (ORDER BY productID) RowNumber FROM Product)\n" +
"                SELECT  * FROM TblCte WHERE RowNumber between ? and ?";
        try {
              DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, (i-1)*5+1);
            pre.setInt(2, (i + 4));
            ResultSet rs = pre.executeQuery();
           
            while (rs.next()) {
                int ProductId = rs.getInt(1);
                String ProductName = rs.getString(2);
                String ProductContent = rs.getString(3);
                String urlImage = "/PhoneSellingMarket/image" + "/" + rs.getString(4);
                String Price = Double.toString(rs.getDouble(5));
                int CatalogueId = rs.getInt(6);

                list.add(new ProductModel(ProductId, ProductName, ProductContent, urlImage, Price, CatalogueId));
            }
          
        } catch (SQLException ex) {
           
            Logger.getLogger(DataDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return list;

    }
    public ArrayList<ProductModel> getProduct() throws Exception {
        ArrayList<ProductModel> prs = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement pre = con.prepareStatement(query.Select_Product);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int ProductId = rs.getInt(1);
                String ProductName = rs.getString(2);
                String ProductContent = rs.getString(3);
                String urlImage = "/PhoneSellingMarket/image" + "/" + rs.getString(4);
                String Price = Double.toString(rs.getDouble(5));
                int CatalogueId = rs.getInt(6);

                prs.add(new ProductModel(ProductId, ProductName, ProductContent, urlImage, Price, CatalogueId));
            }

        } catch (SQLException ex) {

            Logger.getLogger(DataDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return prs;
    }
    
    public List<UserModel> selectAccount() throws Exception {
        try {
            List<UserModel> list = new ArrayList<>();
            Connection connection = new DBContext().getConnection();
            PreparedStatement ps = connection.prepareCall(query.Select_User);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt(1);
                String userName = rs.getString(2);
                String password = rs.getString(3);
                list.add(new UserModel(userID, userName, password));
            }
            rs.close();
            connection.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ProductModel getPrsDetail(int i) throws Exception {
        ProductModel prs = new ProductModel();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement pre = con.prepareStatement(query.Show_Product_Detail);
            pre.setInt(1, i);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int ProductId = rs.getInt(1);
                String ProductName = rs.getString(2);
                String ProductContent = rs.getString(3);
                String urlImage = "/PhoneSellingMarket/image" + "/" + rs.getString(4);
                String Price = Double.toString(rs.getDouble(5));
                int CatalogueId = rs.getInt(6);

                prs = new ProductModel(ProductId, ProductName, ProductContent, urlImage, Price, CatalogueId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return prs;
    }
    
    public int getNumberProduct() throws Exception {
        int n = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement pre = con.prepareStatement(query.Select_Product);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                n++;
            }           
        } catch (SQLException ex) {        
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return n;
    }
    
    public String getPassword(String username) throws Exception {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "SELECT password FROM [User] WHERE username = '" + username + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String password = rs.getString(1);
                return password;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<CartModel> getCart(int i) throws Exception {
        
        List<CartModel> prs = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement pre = con.prepareStatement(query.Show_Cart);
            pre.setInt(1, i);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt(1);
                int productID = rs.getInt(2);
                int quantity = rs.getInt(3);
                int cartID = rs.getInt(4);
                int status = rs.getInt(5);
                String urlImage = "/PhoneSellingMarket/image" + "/" + rs.getString(6);
                String content = rs.getString(7);
                String name = rs.getString(8);
                float price = rs.getFloat(9);
                prs.add(new CartModel(userID, productID, quantity, cartID, status, urlImage, content, name, price)) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return prs;
    }
    
    public void insertCart(CartModel cart) throws Exception{
        try {
            //UserID, ProductID, Quantity, Status
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement pre = con.prepareStatement(query.Insert_Cart);
            pre.setInt(1, cart.getUserID());
            pre.setInt(2, cart.getProductID());
            pre.setInt(3, cart.getQuantity());
            pre.setInt(4, 0);
            pre.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    
    }
}


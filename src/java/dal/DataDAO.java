/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import Model.ProductModel;
import Model.UserModel;
import Query.Query;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public ArrayList<ProductModel> getProduct(int i) throws Exception {
        ArrayList<ProductModel> list = new ArrayList();
        String sql = "  WITH TblCte as (SELECT  *,ROW_NUMBER() OVER (ORDER BY productID) RowNumber FROM Product)\n" +
"                SELECT  * FROM TblCte WHERE RowNumber between ? and ?";
        try {
              DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, i);
            pre.setInt(2, (i + 5));
            ResultSet rs = pre.executeQuery();
           
            while (rs.next()) {
                int ProductId = rs.getInt(1);
                String ProductName = rs.getString(2);
                String ProductContent = rs.getString(3);
                String urlImage = "images" + "/" + rs.getString(4);
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
                String urlImage = "images" + "/" + rs.getString(4);
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
                String urlImage = "images" + "/" + rs.getString(4);
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
}

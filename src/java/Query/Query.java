/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

/**
 *
 * @author Beloyten
 */
public  class Query {
    public final String Select_User = "SELECT * FROM [User]";
    public final String Select_Product ="SELECT * FROM Product"; 
    public final String Select_By_Catalogue = "SELECT * FROM Product WHERE CatalogueID = ?";
    public final String Insert_Cart = "INSERT into Cart(UserID, ProductID, Quantity, Status) VALUES ( ?, ?, ?, ?)";
    public final String Show_Cart = "SELECT c.UserID, p.ProductID, c.Quantity, c.CartID, c.[Status],p.Picture,  p.ProductContent, p.ProductName, p.Price FROM Cart c Join Product p ON c.ProductID=p.ProductID WHERE UserID = ?";
    public final String Show_Product_Detail = "SELECT * FROM Product WHERE ProductID = ?";
    public final String Delete_Cart = "DELETE FROM Cart WHERE CartID = ?";
    public final String Show_Catalogue = "SELECT * FROM Catalogue";
}

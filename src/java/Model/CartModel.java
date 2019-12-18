/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Beloyten
 */
public class CartModel {
    private int UserID;
    private int ProductID;
    private int Quantity;
    private int CartID;
    private int Status;

    public CartModel() {
    }

    public CartModel(int UserID, int ProductID, int Quantity, int CartID, int Status) {
        this.UserID = UserID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.CartID = CartID;
        this.Status = Status;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getCartID() {
        return CartID;
    }

    public void setCartID(int CartID) {
        this.CartID = CartID;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    
}

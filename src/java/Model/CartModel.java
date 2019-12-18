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
    private int userID;
    private int productID;
    private int quantity;
    private int cartID;
    private int status;
    private String picture;

    public CartModel() {
    }

    public CartModel(int userID, int productID, int quantity, int cartID, int status) {
        this.userID = userID;
        this.productID = productID;
        this.quantity = quantity;
        this.cartID = cartID;
        this.status = status;
    }

    public CartModel(int userID, int productID, int quantity, int cartID, int status, String picture) {
        this.userID = userID;
        this.productID = productID;
        this.quantity = quantity;
        this.cartID = cartID;
        this.status = status;
        this.picture = picture;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    
    
    
}

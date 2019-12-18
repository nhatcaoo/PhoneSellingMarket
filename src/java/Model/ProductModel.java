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
public class ProductModel {
    private int productID;
    private String productName;
    private String productContent;
    private String pricture;
    private String price;
    private int catalogueID;

    public ProductModel(int productID, String productName, String productContent, String pricture, String price, int catalogueID) {
        this.productID = productID;
        this.productName = productName;
        this.productContent = productContent;
        this.pricture = pricture;
        this.price = price;
        this.catalogueID = catalogueID;
    }

    public ProductModel() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getPricture() {
        return pricture;
    }

    public void setPricture(String pricture) {
        this.pricture = pricture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCatalogueID() {
        return catalogueID;
    }

    public void setCatalogueID(int catalogueID) {
        this.catalogueID = catalogueID;
    }

    
    
    
}

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
    private int ProductID;
    private String ProductName;
    private String ProductContent;
    private String Pricture;
    private String Price;
    private int CatalogueID;

    public ProductModel() {
    }

    public ProductModel(int ProductID, String ProductName, String ProductContent, String Pricture, String Price, int CatalogueID) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductContent = ProductContent;
        this.Pricture = Pricture;
        this.Price = Price;
        this.CatalogueID = CatalogueID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductContent() {
        return ProductContent;
    }

    public void setProductContent(String ProductContent) {
        this.ProductContent = ProductContent;
    }

    public String getPricture() {
        return Pricture;
    }

    public void setPricture(String Pricture) {
        this.Pricture = Pricture;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public int getCatalogueID() {
        return CatalogueID;
    }

    public void setCatalogueID(int CatalogueID) {
        this.CatalogueID = CatalogueID;
    }
    
    
}

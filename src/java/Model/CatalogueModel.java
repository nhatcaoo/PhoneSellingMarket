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
public class CatalogueModel {
    private int catalogueID;
    private String catalogueName;

    public int getCatalogueID() {
        return catalogueID;
    }

    public void setCatalogueID(int catalogueID) {
        this.catalogueID = catalogueID;
    }

    public String getCatalogueName() {
        return catalogueName;
    }

    public void setCatalogueName(String catalogueName) {
        this.catalogueName = catalogueName;
    }

    public CatalogueModel(int catalogueID, String catalogueName) {
        this.catalogueID = catalogueID;
        this.catalogueName = catalogueName;
    }

    public CatalogueModel() {
    }

  
    
}

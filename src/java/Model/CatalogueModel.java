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
    private int CatalogueID;
    private String CatalogueName;

    public CatalogueModel() {
    }

    public CatalogueModel(int CatalogueID, String CatalogueName) {
        this.CatalogueID = CatalogueID;
        this.CatalogueName = CatalogueName;
    }

    public int getCatalogueID() {
        return CatalogueID;
    }

    public void setCatalogueID(int CatalogueID) {
        this.CatalogueID = CatalogueID;
    }

    public String getCatalogueName() {
        return CatalogueName;
    }

    public void setCatalogueName(String CatalogueName) {
        this.CatalogueName = CatalogueName;
    }
    
}

package com.myweb.smartshoppingapp.data.model;

import org.json.JSONObject;

public class LignePanierCommande {
    private String lignePanierCommandeId;

    private String quantite;

    private JSONObject product;

    private String idCom;

    public LignePanierCommande(String lignePanierCommandeId, String quantite, JSONObject product, String idCom) {
        this.lignePanierCommandeId = lignePanierCommandeId;
        this.quantite = quantite;
        this.product = product;
        this.idCom = idCom;
    }

    public String getLignePanierCommandeId() {
        return lignePanierCommandeId;
    }

    public void setLignePanierCommandeId(String lignePanierCommandeId) {
        this.lignePanierCommandeId = lignePanierCommandeId;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public JSONObject getProduct() {
        return product;
    }

    public void setProduct(JSONObject product) {
        this.product = product;
    }

    public String getIdCom() {
        return idCom;
    }

    public void setIdCom(String idCom) {
        this.idCom = idCom;
    }
}

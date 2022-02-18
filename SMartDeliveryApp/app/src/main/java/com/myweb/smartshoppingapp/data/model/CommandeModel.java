package com.myweb.smartshoppingapp.data.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;

public class CommandeModel {
    private String commandeId;

    private String date_commande;

    private String etat;

    /*
    private Login livreur;

    private Login login;


    private List<LignePanierCommande> lignePanierCommande;
    */

    private JSONObject livreur;

    private JSONObject login;


    private JSONArray lignePanierCommande;

    public CommandeModel(String commandeId, String date_commande, String etat, JSONObject livreur, JSONObject login, JSONArray lignePanierCommande) {
        this.commandeId = commandeId;
        this.date_commande = date_commande;
        this.etat = etat;
        this.livreur = livreur;
        this.login = login;
        this.lignePanierCommande = lignePanierCommande;
    }

    //	@OneToMany(cascade = {CascadeType.DETACH , CascadeType.PERSIST
//            , CascadeType.MERGE , CascadeType.REFRESH})
//    @JoinColumn(name = "lignePanierCommandeId")
//	private LignePanierCommande lignePanierCommande;


    public String getCommandeId() {
        return commandeId;
    }


    public void setCommandeId(String commandeId) {
        this.commandeId = commandeId;
    }


    public String getDate_commande() {
        return date_commande;
    }


    public void setDate_commande(String date_commande) {
        this.date_commande = date_commande;
    }


    public String getEtat() {
        return etat;
    }


    public void setEtat(String etat) {
        this.etat = etat;
    }


    public JSONObject getLogin() {
        return login;
    }


    public void setLogin(JSONObject login) {
        this.login = login;
    }


    public JSONArray getLignePanierCommande() {
        return lignePanierCommande;
    }


    public void setLignePanierCommande(JSONArray lignePanierCommande) {
        this.lignePanierCommande = lignePanierCommande;
    }

    public JSONObject getLivreur() {
        return livreur;
    }

    public void setLivreur(JSONObject livreur) {
        this.livreur = livreur;
    }
}

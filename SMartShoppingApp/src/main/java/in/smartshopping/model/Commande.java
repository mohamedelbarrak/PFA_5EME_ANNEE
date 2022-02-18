package in.smartshopping.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commandeId;
	
	private Date date_commande;
	
	private Boolean etat;
	
    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.PERSIST
            , CascadeType.MERGE , CascadeType.REFRESH})
    @JoinColumn(name = "idLiv")
    private Login livreur;
    
    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.PERSIST
            , CascadeType.MERGE , CascadeType.REFRESH})
    @JoinColumn(name = "id")
    private Login login;


	@OneToMany(cascade = {CascadeType.DETACH , CascadeType.PERSIST
            , CascadeType.MERGE , CascadeType.REFRESH})
    @JoinColumn(name = "lignePanierCommandeId")
	private List<LignePanierCommande> lignePanierCommande;


//	@OneToMany(cascade = {CascadeType.DETACH , CascadeType.PERSIST
//            , CascadeType.MERGE , CascadeType.REFRESH})
//    @JoinColumn(name = "lignePanierCommandeId")
//	private LignePanierCommande lignePanierCommande;
	
	
	public int getCommandeId() {
		return commandeId;
	}


	public void setCommandeId(int commandeId) {
		this.commandeId = commandeId;
	}


	public Date getDate_commande() {
		return date_commande;
	}


	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}


	public Boolean getEtat() {
		return etat;
	}


	public void setEtat(Boolean etat) {
		this.etat = etat;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public List<LignePanierCommande> getLignePanierCommande() {
		return lignePanierCommande;
	}


	public void setLignePanierCommande(List<LignePanierCommande> lignePanierCommande) {
		this.lignePanierCommande = lignePanierCommande;
	}
	

//	public LignePanierCommande getLignePanierCommande() {
//		return lignePanierCommande;
//	}
//
//
//	public void setLignePanierCommande(LignePanierCommande lignePanierCommande) {
//		this.lignePanierCommande = lignePanierCommande;
//	}
	
}

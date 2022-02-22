package in.smartshopping.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "lignePanierCommande")
public class LignePanierCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lignePanierCommandeId;
	
	private int quantite;
	
    @ManyToOne(cascade = {CascadeType.DETACH , CascadeType.PERSIST
            , CascadeType.MERGE , CascadeType.REFRESH})
    @JoinColumn(name = "productId")
    private Product product;

    private int idCom;
    
    
	public int getLignePanierCommandeId() {
		return lignePanierCommandeId;
	}

	public void setLignePanierCommandeId(int lignePanierCommandeId) {
		this.lignePanierCommandeId = lignePanierCommandeId;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public int getIdCom() {
		return quantite;
	}

	public void setIdCom(int quantite) {
		this.quantite = quantite;
	}
    
}

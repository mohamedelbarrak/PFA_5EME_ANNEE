package in.smartshopping.repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.smartshopping.model.Commande;


@Repository
public interface CommandeRepo extends JpaRepository<Commande, Integer> {

    List<Commande> findAll();
    
    Optional<Commande> findBycommandeId(int commandeId);

	//void updateCommande(int id, Commande commande);
	//public Commande updateCommande(int id, Commande commande );

    //@Query("SELECT e FROM Commande e WHERE e.id=(SELECT MAX(id) as id FROM Commande)")		SELECT e FROM Commande e WHERE e.id=?1
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Commande SET etat = true WHERE id=?1")
    void getCommandeHavingMaxId(int id);
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Commande SET etat = false WHERE id=?1")
    void getCommandeHavingMaxId1(int id);

    
    
    
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Commande SET etat = false WHERE id=1")
    void getCommandeHavingMaxId2();
    
    
    
    
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Commande SET etat = true WHERE id=?1")
    void getCommandeHavingMaxId8(int id);
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Commande SET etat = false WHERE id=?1")
    void getCommandeHavingMaxId18(int id);
    
    
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Commande SET id_liv = ?2 WHERE id=?1")
    void getCommandeHavingMaxIdx(int id, int id_liv);
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Commande SET id_liv = 1 WHERE id=?1")
    void getCommandeHavingMaxId0(int id);
    
    
    
    
    
    
    
    
    

    
}
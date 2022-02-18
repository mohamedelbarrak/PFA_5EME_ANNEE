package in.smartshopping.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.smartshopping.model.LignePanierCommande;

@Repository
public interface LignePanierCommandeRepo extends JpaRepository<LignePanierCommande, Integer> {

    List<LignePanierCommande> findAll();
    
    Optional<LignePanierCommande> findBylignePanierCommandeId(int lignePanierCommandeId);

    List<LignePanierCommande> findByidCom(int idCom);
}
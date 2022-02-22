package in.smartshopping.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.smartshopping.model.Login;

public interface LoginRepo extends JpaRepository<Login, Integer> {

	Optional<Login> findByUsernameAndPassword(String username, String password);

}

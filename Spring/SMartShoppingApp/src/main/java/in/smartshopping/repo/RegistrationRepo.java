package in.smartshopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.smartshopping.model.Login;
import in.smartshopping.model.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Integer> {

}

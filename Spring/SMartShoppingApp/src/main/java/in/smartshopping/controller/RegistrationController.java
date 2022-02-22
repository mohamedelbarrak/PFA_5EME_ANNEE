package in.smartshopping.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.smartshopping.model.Login;
import in.smartshopping.model.LoginRegistration;
import in.smartshopping.model.Registration;
import in.smartshopping.repo.LoginRepo;
import in.smartshopping.repo.RegistrationRepo;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationRepo registrationRepo;
	
	@Autowired
	private LoginRepo loginRepo;
	
	@GetMapping("/registration/list")
	public List<Registration> getAllData() {
		
		return registrationRepo.findAll();
	}
	
	@GetMapping("/Registration/{id}")
	public Optional<Registration> getDataById(@PathVariable int id) {
		
		return registrationRepo.findById(id);
	}
	
	
	@PostMapping("/registration/login/add")
	public Map putNewDataOnDb(@RequestBody LoginRegistration loginRegistration) {
		
		
		
		Registration registration = new Registration();
		registration.setAddress1(loginRegistration.getAddress1());
		registration.setCity(loginRegistration.getCity());
		registration.setDob(loginRegistration.getDob());
		registration.setFullname(loginRegistration.getFullname());
		registration.setGender(loginRegistration.getGender());
		registration.setPincode(loginRegistration.getPincode());
		registration.setState(loginRegistration.getState());
		
		Login login = new Login();
		login.setEmail(loginRegistration.getEmail());
		login.setMobile(loginRegistration.getMobile());
		login.setPassword(loginRegistration.getPassword());
		login.setRole(1);
		login.setUsername(loginRegistration.getUsername());
		loginRepo.save(login);
		registration.setLoginId(login.getId());
	
		registrationRepo.save(registration);
		Map<String,String> response = new HashMap<>();
		response.put("message", "Inserted Successfully");
		return response;
		
	}
	
	
	
	@PostMapping("/registration/add")
	public Map putNewDataOnDb(@RequestBody Registration registration) {
		
		registrationRepo.save(registration);
		Map<String,String> response = new HashMap<>();
		response.put("message", "Inserted Successfully");
		return response;
		
	}
	
	@PutMapping("/Registration/update")
	public Map updateDataOnDb(@RequestBody Registration registration) throws Exception {
		if(registration.getId() > 0) {
		registrationRepo.save(registration);
		Map<String,String> response = new HashMap<>();
		response.put("message", "Updated Successfully");
		return response;
		}
		else {
			throw new Exception("Bad Request for Update!");
		}
		
	}

	
	@DeleteMapping("/Registration/delete")
	public Map deleteDataOnDb(@RequestBody Registration registration) throws Exception {
		if(registration.getId() > 0) {
		registrationRepo.delete(registration);
		Map<String,String> response = new HashMap<>();
		response.put("message", "Deleted Successfully");
		return response;
		}
		else {
			throw new Exception("Bad Request for Update!");
		}
		
	}
}

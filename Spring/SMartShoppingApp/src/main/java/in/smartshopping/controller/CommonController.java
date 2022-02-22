package in.smartshopping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

	@GetMapping("/")
	private String handleAllRequest() {
		
		return "Invalid Page Request 404 Error!";
	}
	
}

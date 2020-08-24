package com.example.userregisteration.resources;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userregisteration.model.AccessTokenDetails;
import com.example.userregisteration.model.User;

@RestController
@RequestMapping("/UserService")
public class RegisterationController {

	@PostMapping("/register")
	@PreAuthorize("hasAuthority('DEPARTMENT_CREATE')")  
	//@PreAuthorize("hasRole('DEPARTMENT_CREATE')")  
	public User register(@RequestBody User user) {
		System.out.println(user);
		// return ResponseEntity.ok().body("User created successfully");
		return user;

	}

	@GetMapping("/MyUser/{userId}")
	@PreAuthorize("permitAll()")  
	public User getMyUser(@PathVariable("userId") String userId) {
		AccessTokenDetails accessTokenMapper = (AccessTokenDetails) ((OAuth2AuthenticationDetails) SecurityContextHolder
				.getContext().getAuthentication().getDetails()).getDecodedDetails();
		System.out.println("accessTokenMapper");
		
		User user = new User();
		user.setAddress("Teaxas");
		user.setName("sa");
		return user;
	}
	
	@GetMapping("/ping")
	@PreAuthorize("permitAll()")  
	public String ping() {
		
		return "ping service endpoint working.";
	}

}

package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService us;
	
	@GetMapping
	public List<User> getAll(){
		
		return us.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id")Integer id) {
		return us.findUserById(id);
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User User){
		us.addUser(User);
		return new ResponseEntity<User>(User, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id")Integer id, @RequestBody User User) {
		User.setUserId(id);
		return us.updateUser(User);
	}
	
	@DeleteMapping("/{id}")
	public User deleteUser(@PathVariable("id")Integer id) {
		return us.deleteUser(new User(id));
	}
}

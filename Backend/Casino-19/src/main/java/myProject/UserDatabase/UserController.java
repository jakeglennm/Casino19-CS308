package myProject.UserDatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	@Autowired
	UserDB userDB;

	@RequestMapping("/users")
	List<User> getUsers() {
		return userDB.findAll();
	}

	@GetMapping("/user/{id}")
	User getPerson(@PathVariable Integer id) {
		return userDB.findOne(id);
	}
	
	@PostMapping("/user")
	User attemptSignup(@RequestBody User p) {		
		
		if(userDB.findByUsername(p.getUsername()).isEmpty()) {
			if(userDB.findByEmail(p.getEmail()).isEmpty()) {
				userDB.save(p);	
				return p;
			}
		}
		
		return null;
	}
	 
	@GetMapping("/login")
	User attemptLogin(@RequestParam String userkey, @ RequestParam String password) {
		
		List<User> temp = userDB.findByUsername(userkey);
		
		System.out.println("actually running controller with " + userkey + " " + password );
		
		if(temp.isEmpty()) {
			temp = userDB.findByEmail(userkey);
			if(temp.isEmpty()) {
				return null;
			}
		}
		
		if(password.equals(temp.get(0).getPassword())) {
			return temp.get(0);
		}
		
		return null;
		
	}
	
	@DeleteMapping("/user/{id}")
	String deletePerson(@PathVariable Integer id) {
		userDB.delete(id);
		return "deleted user: " + id;
	}

	@DeleteMapping("/users/clearall")
	String deleteAllUsers() {
		userDB.deleteAll();
		return "deleted all";
	}

}

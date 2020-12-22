package myProject;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import myProject.UserDatabase.User;
import myProject.UserDatabase.UserController;
import myProject.UserDatabase.UserDB;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {

	@Autowired
	private MockMvc controller;
	
	@MockBean
	private UserDB userDB; 
	
	@MockBean
	private User mockUser;
	
	String mockUserkey = "athoreso";
	String mockEmail = "athoreso@iastate.edu";
	String mockPassword = "Skill14!!";
	
	
	@Test
	public void testSuccessfulUserLogin() throws Exception {
		//Given hardcoded userkey and password
		
		//Setting up mock methods
		//Mock db finding by username

		List<User> tempUserList = new ArrayList<User>();
		tempUserList.add(new User(mockUserkey, mockEmail, mockPassword));
		
		when(userDB.findByUsername(mockUserkey)).thenReturn(tempUserList);
		when(userDB.findByEmail(mockEmail)).thenReturn(tempUserList);
	
		controller.perform(get("/login")
				.param("userkey", mockUserkey)
				.param("password" , mockPassword))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.username").value("athoreso"))
				.andExpect(jsonPath("$.email").value("athoreso@iastate.edu"))
				.andExpect(jsonPath("$.password").value("Skill14!!"));
		
	}
	
	@Test
	public void testFailedUserLogin() throws Exception {
		//Given hardcoded userkey and password

		//Setting up mock methods
		//Mock db finding by username
		
		List<User> tempUserList = new ArrayList<User>();
		tempUserList.add(new User(mockUserkey, mockEmail, mockPassword));
		
		//this is a failed attempt with incorrect userkey
		when(userDB.findByUsername("athoriso")).thenReturn(new ArrayList<User>());
		when(userDB.findByEmail("athoreso@iastate.edu")).thenReturn(new ArrayList<User>());

		//should return null, which will give an error
		controller.perform(get("/login")
				.param("userkey", mockUserkey)
				.param("password" , mockPassword))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").doesNotExist())
				.andExpect(jsonPath("$.email").doesNotExist())
				.andExpect(jsonPath("$.password").doesNotExist());
		
		
	}
	
	@Test
	public void testCreateUniqueUser() throws Exception {
		
		//Setting up mock methods
		//Mock db finding by username
				
		//mock the user methods
		when(mockUser.getUsername()).thenReturn(mockUserkey);
		when(mockUser.getEmail()).thenReturn(mockEmail);
		
		//this is a successful creation of a new unique user
		when(userDB.findByUsername(mockUser.getUsername())).thenReturn(new ArrayList<User>());
		when(userDB.findByEmail(mockUser.getEmail())).thenReturn(new ArrayList<User>());
				
		//should return null
		controller.perform(post("/user") 
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"username\":\"athoreso\",\"password\":\"Skill14!!\",\"email\":\"athoreso@iastate.edu\",\"balance\":null,\"role\":null}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").value("athoreso"))
				.andExpect(jsonPath("$.email").value("athoreso@iastate.edu"))
				.andExpect(jsonPath("$.password").value("Skill14!!"));
	}
	
	@Test
	public void testCreateNonUniqueUser() throws Exception {
		//Given hardcoded userkey and password

		//Setting up mock methods
		//mock the user methods
		when(mockUser.getUsername()).thenReturn(mockUserkey);
		when(mockUser.getEmail()).thenReturn(mockEmail);
		
		List<User> tempList = new ArrayList<User>();
		tempList.add(new User(mockUserkey, mockEmail, mockPassword));
		
		//this is a failed creation of a new user
		when(userDB.findByUsername(mockUser.getUsername())).thenReturn(tempList);
		when(userDB.findByEmail(mockUser.getEmail())).thenReturn(tempList);
				
		//should return null
		controller.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"username\":\"athoreso\",\"password\":\"Skill14!!\",\"email\":\"athoreso@iastate.edu\",\"balance\":null,\"role\":null}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").doesNotExist())
				.andExpect(jsonPath("$.email").doesNotExist())
				.andExpect(jsonPath("$.password").doesNotExist());
	}
	
	
}

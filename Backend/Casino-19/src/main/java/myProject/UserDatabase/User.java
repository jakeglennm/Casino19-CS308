package myProject.UserDatabase;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column
	String username;
	
	@Column
	String password;

	@Column
	String email;
	
	@Column
	Integer balance;
	
	@Column
	String role;

	public Integer getId() { return id; }
	
	User() {}
	
	public User(String userkey, String email, String password) {
		this.username = userkey;
		this.email = email;
		this.password = password;
		this.balance = 0;
		this.role = "admin";

	}
	
	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public String getEmail() { return email; }

	public Integer getBalance() { return balance; }
	public String getRole() { return role; }
	
	public Integer adjustBalance(Integer newBalance ) { return this.balance += newBalance; }

}

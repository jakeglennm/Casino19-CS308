package myProject.UserDatabase;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDB extends JpaRepository<User, Integer> {

	List<User> findByUsername(String username);
	List<User> findByEmail(String email);
	
}

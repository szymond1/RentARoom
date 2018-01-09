package pl.dubiel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.dubiel.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByuserName(String userNames);

	
}

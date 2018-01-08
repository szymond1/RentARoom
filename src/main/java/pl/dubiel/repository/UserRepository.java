package pl.dubiel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.dubiel.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByuserName(String userNames);
	
}

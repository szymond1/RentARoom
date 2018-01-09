package pl.dubiel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.dubiel.entity.Flat;
import pl.dubiel.entity.User;


public interface FlatRepository extends JpaRepository<Flat, Long> {

	List<Flat> findByUserId(Long id);
	List<Flat> findByUserIdOrderByCreatedDesc(Long id);
}

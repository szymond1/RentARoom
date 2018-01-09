package pl.dubiel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.dubiel.entity.Flat;


public interface FlatRepository extends JpaRepository<Flat, Long> {

	
}

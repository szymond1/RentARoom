package pl.dubiel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import pl.dubiel.entity.Photos;
import pl.dubiel.entity.User;


public interface PhotosRepository extends JpaRepository<Photos, Long> {

	List<Photos> findByFlatId(Long id);

	
}

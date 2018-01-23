package pl.dubiel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.dubiel.entity.Flat;
import pl.dubiel.entity.Rating;



public interface RatingRepository extends JpaRepository<Rating, Long> {

	List<Rating> findByFlatId(long id);
	@Query("SELECT AVG(r.overall) FROM Rating r WHERE r.flat = :flat")
	double getAverageRating(@Param("flat") Flat flat);

}

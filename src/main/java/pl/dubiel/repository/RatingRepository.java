package pl.dubiel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.dubiel.entity.Rating;



public interface RatingRepository extends JpaRepository<Rating, Long> {


}

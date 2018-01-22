package pl.dubiel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.dubiel.entity.Comment;
import pl.dubiel.entity.Flat;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByFlatIdOrderByCreatedAsc(Long id);
	List<Comment> findByFlatIdOrderByCreatedDesc(Long id);
	List<Comment> findByFlat(Flat flat);

}

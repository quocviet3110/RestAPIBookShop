package poly.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.CommentEntity;



@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
	@Query("SELECT c FROM CommentEntity c INNER JOIN c.bookComment b WHERE b.id= ?1")
	List<CommentEntity> findAllByIdBook(int idBook);

}

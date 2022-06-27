package poly.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.PublisherEntity;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity, Integer> {
	 @Query("SELECT p FROM PublisherEntity p INNER JOIN p.books b WHERE b.id= ?1")
	 PublisherEntity findOneByIdBook(int idBook);

}

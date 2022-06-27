package poly.bookshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.BookEntity;




@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
	@Query("SELECT b FROM BookEntity b INNER JOIN b.category c WHERE  c.name LIKE %?1% OR b.name LIKE %?1% OR b.title LIKE %?1%")
	public  Page<BookEntity> search(String keyword, Pageable pageable);
	
	@Query("SELECT count(*) FROM BookEntity b INNER JOIN b.category c WHERE  c.name LIKE %?1% OR b.name LIKE %?1% OR b.title LIKE %?1%")
	public  int countSearch(String keyword);
	
	@Query("SELECT b FROM BookEntity b INNER JOIN b.category c WHERE c.id= ?1")
	public List<BookEntity> findAllByIdCategory(int idCategory);
	
	@Query("SELECT b FROM BookEntity b  WHERE b.id= ?1")
	public BookEntity findOneByID(int idBook);
}

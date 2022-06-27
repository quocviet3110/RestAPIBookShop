package poly.bookshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.PayInEntity;

@Repository
public interface PayInRepository  extends JpaRepository<PayInEntity, Integer>{
	@Query("SELECT count(*) FROM PayInEntity p INNER JOIN p.staffPayIn s WHERE  s.name LIKE %?1% OR p.date LIKE %?1%")
	Integer countSearch(String keyword);
	
	@Query("SELECT p FROM PayInEntity p INNER JOIN p.staffPayIn s WHERE  s.name LIKE %?1% OR p.date LIKE %?1%")
	Page<PayInEntity> search(String keyword, Pageable pageable);

}

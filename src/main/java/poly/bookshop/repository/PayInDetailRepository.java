package poly.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.PayInDetailEntity;
import poly.bookshop.entity.PayInKeyID;

@Repository
public interface PayInDetailRepository extends JpaRepository<PayInDetailEntity, PayInKeyID>  {
	@Query("SELECT p FROM PayInDetailEntity p  WHERE p.id= ?1")
	List<PayInDetailEntity> findAllByID(int id);

}

package poly.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.OrderDetailEntity;
import poly.bookshop.entity.OrderKeyID;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,OrderKeyID> {
	@Query("SELECT o FROM OrderDetailEntity o  WHERE o.id= ?1")
	List<OrderDetailEntity> findAllById(int id);

}

package poly.bookshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.OrderEntity;
import poly.bookshop.entity.PayInEntity;


@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	@Query("SELECT o FROM OrderEntity o INNER JOIN o.customerOrder customer INNER JOIN customer.users u  WHERE u.username= ?1")
	List<OrderEntity> findAllByIdCustomer(String username);
	@Query("SELECT count(*) FROM OrderEntity o INNER JOIN o.customerOrder c WHERE  c.name LIKE %?1% OR o.date LIKE %?1% OR o.id LIKE %?1%")
	Integer countSearch(String keyword);
	
	@Query("SELECT o FROM OrderEntity o INNER JOIN o.customerOrder c WHERE  c.name LIKE %?1% OR o.date LIKE %?1% OR o.id LIKE %?1%")
	Page<OrderEntity> search(String keyword, Pageable pageable);
}

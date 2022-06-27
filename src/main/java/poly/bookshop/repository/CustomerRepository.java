package poly.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.CustomerEntity;



@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
	@Query("SELECT c FROM CustomerEntity c INNER JOIN c.users u WHERE u.username= ?1")
	CustomerEntity findByUsername(String username);

	boolean existsByEmail(String email);
	
	@Query("SELECT c FROM CustomerEntity c WHERE c.id= ?1")
	CustomerEntity findByCusId(int idCustomer);

}

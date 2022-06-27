package poly.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.CartEntity;



@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer>{
	@Query("SELECT c FROM CartEntity c INNER JOIN c.customerCart customer INNER JOIN customer.users u WHERE u.username= ?1")
	List<CartEntity> findAllByUsername(String username);
	/*
	 * @Query("SELECT CASE WHEN COUNT(c) > 0 THEN 'true' ELSE 'false' END  FROM CartEntity c  WHERE  c.bookCart.id in (SELECT id FROM BookEntity b WHERE b.id = ?1)\r\n"
	 * +
	 * "	 AND c.customerCart.username in (SELECT u.username FROM  UserEntity u WHERE u.username = ?2)"
	 * ) Boolean existsByBook(int idBook,String username);
	 */

	

}

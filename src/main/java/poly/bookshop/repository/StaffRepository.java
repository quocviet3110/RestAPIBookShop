package poly.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.StaffEntity;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Integer>{
	@Query("SELECT s FROM StaffEntity s INNER JOIN s.userStaff u WHERE u.username= ?1")
	StaffEntity findByUsernamr(String username);

}

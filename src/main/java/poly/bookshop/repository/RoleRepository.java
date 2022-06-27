package poly.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
	RoleEntity findByCode(String code);
}

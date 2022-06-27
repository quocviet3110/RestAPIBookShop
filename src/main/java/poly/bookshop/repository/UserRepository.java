package poly.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	UserEntity findOneByUsername( String username);

	boolean existsByUsername(String username);
}

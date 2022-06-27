package poly.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.AuthorEntity;


@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

}

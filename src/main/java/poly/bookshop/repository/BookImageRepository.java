package poly.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.BookImageEntity;



@Repository
public interface BookImageRepository extends JpaRepository<BookImageEntity, Integer> {

}

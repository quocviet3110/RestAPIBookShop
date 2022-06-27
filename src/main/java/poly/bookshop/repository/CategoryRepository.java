package poly.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.CategoryEntity;



@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

}

package poly.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.PriceEntity;

@Repository
public interface PriceRepostory extends JpaRepository<PriceEntity, Integer> {

}

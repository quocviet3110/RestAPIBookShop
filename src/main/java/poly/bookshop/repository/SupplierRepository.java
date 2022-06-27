package poly.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.bookshop.entity.SupplierEntity;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer> {

}

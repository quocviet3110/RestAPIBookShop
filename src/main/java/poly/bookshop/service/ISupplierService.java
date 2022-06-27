package poly.bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poly.bookshop.dto.SupplierDTO;

@Service
public interface ISupplierService {
	SupplierDTO save(SupplierDTO supplierDTO);
	SupplierDTO findOneById(int id);
	List<SupplierDTO> findAll();
}

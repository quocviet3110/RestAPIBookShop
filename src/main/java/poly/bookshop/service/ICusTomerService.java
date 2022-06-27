package poly.bookshop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.CustomerDTO;

@Service
public interface ICusTomerService {
	CustomerDTO save(CustomerDTO customerDTO);
	CustomerDTO findOneById(int id);
	List<CustomerDTO>  findAll(Pageable pageable);
	int getTotalItem();	
	int delete(int ids[]);
}

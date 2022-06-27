package poly.bookshop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.OrderDTO;

@Service
public interface IOrderService {
	OrderDTO save(OrderDTO orderDTO);
	OrderDTO findOneById(int id);
	List<OrderDTO>  findAll(Pageable pageable);
	int getTotalItem();	
	int delete(int ids[]);
	List<OrderDTO> findAllByIdCustomer(String username);
	List<OrderDTO> findAll(int page, int limit, String sortBy, String sortName);
	List<OrderDTO> search(String keyword, int page, int limit, String sortBy, String sortName);
	Integer getToTalItemSearch(String keyword);
}

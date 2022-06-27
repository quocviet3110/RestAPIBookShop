package poly.bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poly.bookshop.dto.CartDTO;

@Service
public interface ICartService {
	List<CartDTO> findAllByIdCustomer(String username);

	CartDTO save(CartDTO model);

	int delete(int[] ids);

}

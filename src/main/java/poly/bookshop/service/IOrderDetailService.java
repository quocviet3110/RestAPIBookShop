package poly.bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poly.bookshop.dto.OrderDetailDTO;

@Service
public interface IOrderDetailService {
	List<OrderDetailDTO> findAllById(int id);
	OrderDetailDTO save(OrderDetailDTO model);
	List<OrderDetailDTO> findAllByID(int id);
}

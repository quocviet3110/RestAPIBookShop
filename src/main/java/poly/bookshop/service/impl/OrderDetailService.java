package poly.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.OrderDetailDTO;
import poly.bookshop.dto.PayInDetailDTO;
import poly.bookshop.entity.BookEntity;
import poly.bookshop.entity.OrderDetailEntity;
import poly.bookshop.entity.OrderEntity;
import poly.bookshop.entity.PayInDetailEntity;
import poly.bookshop.repository.BookRepository;
import poly.bookshop.repository.OrderDetailRepository;
import poly.bookshop.repository.OrderRepository;
import poly.bookshop.service.IOrderDetailService;

@Service
@Transactional
public class OrderDetailService implements IOrderDetailService {
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private BookRepository bookRepository;
	
	private OrderDetailDTO mapToDtoDetail(OrderDetailEntity orderDetailEntity) {
		OrderDetailDTO orderDetailDTO = mapper.map(orderDetailEntity, OrderDetailDTO.class);
		return orderDetailDTO;
	}
	private OrderDetailEntity mapToEntity(OrderDetailDTO orderDetailDTO) {
		OrderDetailEntity OrderDetailEntity = mapper.map(orderDetailDTO, OrderDetailEntity.class);
		return OrderDetailEntity;
	}
	@Override
	public List<OrderDetailDTO> findAllById(int id) {
		List<OrderDetailEntity> entities = orderDetailRepository.findAllById(id);
		List<OrderDetailDTO> results = new ArrayList<OrderDetailDTO>();
		for(OrderDetailEntity item : entities) {
		
			results.add(this.mapToDtoDetail(item));
		}
		return results;
	}

	@Override
	public OrderDetailDTO save(OrderDetailDTO model) {
		OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
		OrderEntity orderEntity = orderRepository.getById(model.getId());
		BookEntity bookEntity = bookRepository.getById(model.getIdBook());
		orderDetailEntity = this.mapToEntity(model);
		orderDetailEntity.setOrderDetail(orderEntity);
		orderDetailEntity.setBookOrder(bookEntity);
		
		return this.mapToDtoDetail(orderDetailRepository.save(orderDetailEntity));
	}
	@Override
	public List<OrderDetailDTO> findAllByID(int id) {
		List<OrderDetailEntity> entity  = orderDetailRepository.findAllById(id);
		List<OrderDetailDTO> results = new ArrayList<>();
		for(OrderDetailEntity item : entity) {
			results.add(this.mapToDtoDetail(item));
		}
		return results;
	}

	
}

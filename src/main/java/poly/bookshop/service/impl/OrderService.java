package poly.bookshop.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.OrderDTO;
import poly.bookshop.entity.CustomerEntity;
import poly.bookshop.entity.OrderEntity;
import poly.bookshop.entity.StoreEntity;
import poly.bookshop.repository.CustomerRepository;
import poly.bookshop.repository.OrderDetailRepository;
import poly.bookshop.repository.OrderRepository;
import poly.bookshop.repository.StaffRepository;
import poly.bookshop.repository.StoreRepository;
import poly.bookshop.service.IOrderService;

@Service
@Transactional
public class OrderService implements IOrderService {
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StoreRepository storeRepository;

	private OrderDTO mapToDto(OrderEntity orderEntity) {
		OrderDTO orderDto = mapper.map(orderEntity, OrderDTO.class);
		return orderDto;
	}
	
	private OrderEntity mapToEntity(OrderDTO orderDTO) {
		OrderEntity orderEntity = mapper.map(orderDTO, OrderEntity.class);
		return orderEntity;
	}

	private OrderEntity mapToEntity(OrderEntity orderEntity, OrderDTO orderDTO) {
		orderEntity = mapper.map(orderDTO, OrderEntity.class);
		return orderEntity;
	}

	@Override
	public OrderDTO save(OrderDTO orderDTO) {
		Date date = new Date();
		OrderEntity orderEntity = new OrderEntity();
		CustomerEntity customerEntity = customerRepository.findByUsername(orderDTO.getUsername());
		Optional<StoreEntity> storeOptional = storeRepository.findById(orderDTO.getIdStore());
		StoreEntity storeEntity = storeOptional.get();
		if (orderDTO.getId() != null) {
			CustomerEntity customer = customerRepository.findByCusId(orderDTO.getIdCustomer());
			Optional<OrderEntity> oldOptional = orderRepository.findById(orderDTO.getId());
			OrderEntity old = oldOptional.get();
			orderEntity = this.mapToEntity(old, orderDTO);
			orderEntity.setCustomerOrder(customer);
			orderEntity.setStoreOrder(storeEntity);
		} else {
			orderEntity = this.mapToEntity(orderDTO);
			orderEntity.setCustomerOrder(customerEntity);
			orderEntity.setStoreOrder(storeEntity);
			orderEntity.setDate(date);
		}
		return this.mapToDto(orderRepository.save(orderEntity));
	}

	@Override
	public OrderDTO findOneById(int id) {
		Optional<OrderEntity> orderOptional = orderRepository.findById(id);
		return this.mapToDto(orderOptional.get());
	}

	@Override
	public List<OrderDTO> findAll(Pageable pageable) {
		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
		List<OrderEntity> entities = orderRepository.findAll(pageable).getContent();
		for (OrderEntity item : entities) {
			
			orderDTOs.add(this.mapToDto(item));
		}
		return orderDTOs;
	}

	@Override
	public int getTotalItem() {
		return (int) orderRepository.count();
	}

	@Override
	public int delete(int[] ids) {
		for (int item : ids) {
			orderRepository.deleteById(item);
		}
		return 0;
	}

	@Override
	public List<OrderDTO> findAllByIdCustomer(String username) {
		List<OrderEntity> entities = orderRepository.findAllByIdCustomer(username);
		List<OrderDTO> results = new ArrayList<OrderDTO>();
		for(OrderEntity item : entities) {
			results.add(this.mapToDto(item));
		}
		return results;
	}

	@Override
	public List<OrderDTO> findAll(int page, int limit, String sortBy, String sortName) {
		Sort sort = sortName.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page-1, limit, sort);
	    Page<OrderEntity> order = orderRepository.findAll(pageable);
		List<OrderDTO> results = new ArrayList<>();
		List<OrderEntity> entity = order.getContent();
		for(OrderEntity item : entity) {
			results.add(this.mapToDto(item));
		}
		return results;
	
	}

	@Override
	public List<OrderDTO> search(String keyword, int page, int limit, String sortBy, String sortName) {
		Sort sort = sortName.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
		 Pageable pageable = PageRequest.of(page-1, limit, sort);
	    Page<OrderEntity> order = orderRepository.search(keyword,pageable);
		List<OrderDTO> results = new ArrayList<>();
		List<OrderEntity> entity = order.getContent();
		for(OrderEntity item : entity) {
			results.add(this.mapToDto(item));
		}
		return results;
	}

	@Override
	public Integer getToTalItemSearch(String keyword) {
		return  orderRepository.countSearch(keyword);
	}

	

}

package poly.bookshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poly.bookshop.constant.SystemContants;
import poly.bookshop.dto.OrderDTO;
import poly.bookshop.dto.OrderDetailDTO;
import poly.bookshop.service.IOrderDetailService;
import poly.bookshop.service.IOrderService;

@CrossOrigin
@RestController
public class OrderAPI {
	
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IOrderDetailService orderDetailService;
	@GetMapping(value = "/api/order/{id}")
	public OrderDTO findOne(@PathVariable("id") int id) {
		return orderService.findOneById(id);
	}
	@GetMapping(value = "/api/findAllByIdCustomer/{username}")
	public List<OrderDTO> showInforByBook(@PathVariable("username") String username) {	
		List<OrderDTO> dtos=orderService.findAllByIdCustomer(username);
		for(OrderDTO item:dtos) {
			List<OrderDetailDTO> detailDTOs = orderDetailService.findAllById(item.getId());
			item.setListOrder(detailDTOs);
		}
		return dtos;
	}
	@PostMapping(value = "/api/order")
	public OrderDTO createOrder(@RequestBody OrderDTO model) {
		return orderService.save(model);
	}
	@PutMapping(value = "/api/order/{id}")
	public OrderDTO updateOrder(@RequestBody OrderDTO model, @PathVariable("id") int id) {
		model.setId(id);
		return orderService.save(model);
	}
	@GetMapping(value = "/api/orderList")
	public OrderDTO showPayIn(@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", defaultValue = SystemContants.DEFAULT_PAGE_NUMBER, required = false) int page,
			@RequestParam(value = "limit", defaultValue = SystemContants.DEFAULT_PAGE_SIZE, required = false) int limit,
			@RequestParam(value = "sortBy", defaultValue = SystemContants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortName", defaultValue = SystemContants.DEFAULT_SORT_DIRECTION, required = false) String sortName) {

		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setPage(page);
		orderDTO.setLimit(limit);
		orderDTO.setSortBy(sortBy);
		orderDTO.setSortBy(sortName);
		if (keyword != null) {
			orderDTO.setTotalItem(orderService.getToTalItemSearch(keyword));
			orderDTO.setTotalPage((int) Math.ceil((double) orderDTO.getTotalItem() / orderDTO.getLimit()));
			orderDTO.setListResult(orderService.search(keyword, page, limit, sortBy, sortName));
		} else {
			orderDTO.setTotalItem(orderService.getTotalItem());
			orderDTO.setTotalPage((int) Math.ceil((double) orderDTO.getTotalItem() / orderDTO.getLimit()));
			orderDTO.setListResult(orderService.findAll(page, limit, sortBy, sortName));
		}

		return orderDTO;
	}
}

package poly.bookshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poly.bookshop.dto.OrderDetailDTO;
import poly.bookshop.dto.PayInDetailDTO;
import poly.bookshop.service.IOrderDetailService;

@CrossOrigin
@RestController
public class OrderDetailAPI {
	@Autowired
	private IOrderDetailService orderDetailService;

	@PostMapping(value = "/api/orderDetailSave")
	public OrderDetailDTO createBook(@RequestBody OrderDetailDTO model) {
		return orderDetailService.save(model);
	}

	@PostMapping(value = "/api/orderDetailSaveAll")
	public void createOrderDetail(@RequestParam(value = "id", required =false) Integer id,
			@RequestParam(value = "idBooks",required = false) List<Integer> idBooks,
			@RequestParam(value ="idsNumber", required = false) List<Integer> idsNumber) {
		
		for(int i=0;i<idBooks.size();i++) {
			OrderDetailDTO detailDTO = new OrderDetailDTO();
			detailDTO.setId(id);
			detailDTO.setIdBook(idBooks.get(i));
			detailDTO.setNumber(idsNumber.get(i));
			orderDetailService.save(detailDTO);
		}
	}
	@GetMapping(value = "/api/orderDetailList/{id}")
	public OrderDetailDTO showPayIn(@PathVariable("id") int id) {
		OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
		orderDetailDTO.setListResult(orderDetailService.findAllByID(id));
		return orderDetailDTO;
	}
}

package poly.bookshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import poly.bookshop.dto.CustomerDTO;
import poly.bookshop.service.ICusTomerService;

@RestController
public class CustomerAPI {
	@Autowired
	private ICusTomerService customerService;
	 @PostMapping("/api/cutomer")
	 public CustomerDTO createBook(@RequestBody CustomerDTO model) {
			return customerService.save(model);
		}

}

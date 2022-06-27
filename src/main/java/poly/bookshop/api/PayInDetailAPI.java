package poly.bookshop.api;

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
import poly.bookshop.dto.PayInDetailDTO;
import poly.bookshop.service.IPayInDetailService;

@CrossOrigin
@RestController
public class PayInDetailAPI {
	@Autowired
	private IPayInDetailService iPayInDetailService;

	@PostMapping(value = "/api/payInDetail")
	public PayInDetailDTO createPayIn(@RequestBody PayInDetailDTO model) {

		return iPayInDetailService.save(model);
	}

	@PutMapping(value = "/api/payInDetail/{id}")
	public PayInDetailDTO updatePayIn(@RequestBody PayInDetailDTO model, @PathVariable("id") int id) {
		model.setId(id);
		return iPayInDetailService.save(model);
	}

	@GetMapping(value = "/api/payInDetailList/{id}")
	public PayInDetailDTO showPayIn(@PathVariable("id") int id) {
		PayInDetailDTO payInDTO = new PayInDetailDTO();
		payInDTO.setListResult(iPayInDetailService.findAllByID(id));
		return payInDTO;
	}

}

package poly.bookshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poly.bookshop.constant.SystemContants;
import poly.bookshop.dto.PayInDTO;
import poly.bookshop.service.IPayInService;

@CrossOrigin
@RestController
public class PayInAPI {
	@Autowired
	private IPayInService iPayInService;

	@PostMapping(value = "/api/payIn")
	public PayInDTO createPayIn(@RequestBody PayInDTO model) {

		return iPayInService.save(model);
	}

	@PutMapping(value = "/api/payIn/{id}")
	public PayInDTO updatePayIn(@RequestBody PayInDTO model, @PathVariable("id") int id) {
		model.setId(id);
		return iPayInService.save(model);
	}

	@GetMapping(value = "/api/payIn/{id}")
	public PayInDTO findOne(@PathVariable("id") int id) {
		return iPayInService.findOneById(id);
	}

	@GetMapping(value = "/api/payInList")
	public PayInDTO showPayIn(@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", defaultValue = SystemContants.DEFAULT_PAGE_NUMBER, required = false) int page,
			@RequestParam(value = "limit", defaultValue = SystemContants.DEFAULT_PAGE_SIZE, required = false) int limit,
			@RequestParam(value = "sortBy", defaultValue = SystemContants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortName", defaultValue = SystemContants.DEFAULT_SORT_DIRECTION, required = false) String sortName) {

		PayInDTO payInDTO = new PayInDTO();
		payInDTO.setPage(page);
		payInDTO.setLimit(limit);
		payInDTO.setSortBy(sortBy);
		payInDTO.setSortBy(sortName);
		if (keyword != null) {
			payInDTO.setTotalItem(iPayInService.getToTalItemSearch(keyword));
			payInDTO.setTotalPage((int) Math.ceil((double) payInDTO.getTotalItem() / payInDTO.getLimit()));
			payInDTO.setListResult(iPayInService.search(keyword, page, limit, sortBy, sortName));
		} else {

			payInDTO.setTotalItem(payInDTO.getTotalItem());
			payInDTO.setTotalPage((int) Math.ceil((double) payInDTO.getTotalItem() / payInDTO.getLimit()));
			payInDTO.setListResult(iPayInService.findAll(page, limit, sortBy, sortName));
		}

		return payInDTO;
	}

	

	@DeleteMapping(value = "/api/payIn")
	public int deleteDTO(@RequestBody int ids[]) {
		int result = iPayInService.delete(ids);
		return result;

	}
}

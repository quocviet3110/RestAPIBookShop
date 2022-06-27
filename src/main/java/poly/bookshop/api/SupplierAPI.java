package poly.bookshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import poly.bookshop.dto.SupplierDTO;
import poly.bookshop.service.ISupplierService;

@CrossOrigin
@RestController
public class SupplierAPI {
	
	
	@Autowired
	private ISupplierService supplierService;
	
	@PostMapping(value = "/supplier")
	public SupplierDTO createSupplier(@RequestBody SupplierDTO model) {
		return supplierService.save(model);
	}
	
	@PutMapping(value = "/supplier/{id}")
	public SupplierDTO updateSupplier(@RequestBody SupplierDTO model, @PathVariable("id") int id) {
		model.setId(id);
		return supplierService.save(model);
	}
	@GetMapping(value = "/supplier/{id}")
	public SupplierDTO findOne(@PathVariable("id") int id) {
		return supplierService.findOneById(id);
	}
	@GetMapping(value = "/api/supplierList")
	public List<SupplierDTO> showList() {
		List<SupplierDTO> result = supplierService.findAll();
		return result;
	}
}

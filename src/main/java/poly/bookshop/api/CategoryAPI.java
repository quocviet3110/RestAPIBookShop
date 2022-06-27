package poly.bookshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.bookshop.dto.CategoryDTO;
import poly.bookshop.service.ICategoryService;

@CrossOrigin
@RestController
public class CategoryAPI {
	@Autowired
	private ICategoryService categorryService;
	@GetMapping(value = "/api/categoryList")
	public List<CategoryDTO> showList() {
		List<CategoryDTO> result = categorryService.findAll();
		return result;
	}
}

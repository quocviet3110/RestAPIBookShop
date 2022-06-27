package poly.bookshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.bookshop.dto.AuthorDTO;
import poly.bookshop.service.IAuthorService;

@CrossOrigin
@RestController
public class AuthorAPI {
	@Autowired
	private IAuthorService authorService;
	
	
	@GetMapping(value = "/api/authorList")
	public List<AuthorDTO> showList() {
		List<AuthorDTO> result = authorService.findAll();
		return result;
	}
}

package poly.bookshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import poly.bookshop.dto.PublisherDTO;
import poly.bookshop.service.IPublisherService;

@CrossOrigin
@RestController
public class PublisherAPI {
	
	@Autowired
	private IPublisherService publisherService;
	
	
	@GetMapping(value = "/api/pubblisherList")
	public List<PublisherDTO> showList() {
		List<PublisherDTO> result = publisherService.findAll();
		return result;
	}
	@GetMapping(value = "/api/findOneByIdBook/{idBook}")
	public PublisherDTO showInforByBook(@PathVariable("idBook") int idBook) {	
		return publisherService.findOneByIdBook(idBook);
	}
}

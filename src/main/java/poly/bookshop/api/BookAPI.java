package poly.bookshop.api;

import java.io.IOException;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import poly.bookshop.constant.SystemContants;
import poly.bookshop.dto.BookDTO;
import poly.bookshop.service.IBookService;
import poly.bookshop.util.Base64ToMultipartFile;

@CrossOrigin
@RestController
public class BookAPI {
	@GetMapping("/demo")
	public String test() {
		return "Hi Loc";
	}

	@Autowired
	private IBookService bookService;
	@Autowired 
	private Cloudinary cloudinary;
	

	@PostMapping(value = "/api/book")
	public BookDTO createBook(@RequestBody BookDTO model) {
		final String[] base64Array = model.getBase64().split(",");
	     String dataUir, data;
	     if (base64Array.length > 1) {
	         dataUir = base64Array[0];
	         data = base64Array[1];
	     } else {
	         //Build according to the specific file you represent
	         dataUir = "data:image/jpg;base64";
	         data = base64Array[0];
	     }
	     MultipartFile fileUpload = new Base64ToMultipartFile(data, dataUir);
		try {
			
			Map r = this.cloudinary.uploader().upload(fileUpload.getBytes(),
					ObjectUtils.asMap("resource_type", "auto"));
			model.setUrlImage((String) r.get("secure_url"));
		} catch (IOException e) {
		}
		return bookService.save(model);
	}

	@PutMapping(value = "/api/book/{id}")
	public BookDTO updateBook(@RequestBody BookDTO model, @PathVariable("id") int id) {
		
		model.setId(id);
		final String[] base64Array = model.getBase64().split(",");
	     String dataUir, data;
	     if (base64Array.length > 1) {
	         dataUir = base64Array[0];
	         data = base64Array[1];
	     } else {
	         //Build according to the specific file you represent
	         dataUir = "data:image/jpg;base64";
	         data = base64Array[0];
	     }
	     MultipartFile fileUpload = new Base64ToMultipartFile(data, dataUir);
		try {
			
			Map r = this.cloudinary.uploader().upload(fileUpload.getBytes(),
					ObjectUtils.asMap("resource_type", "auto"));
			model.setUrlImage((String) r.get("secure_url"));
		} catch (IOException e) {
		}
		return bookService.save(model);
	}

	@GetMapping(value = "/api/book/{id}")
	public BookDTO findOne(@PathVariable("id") int id) {
		return bookService.findOneById(id);
	}

	@GetMapping(value = "/api/bookList")
	public BookDTO showBook(@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", defaultValue = SystemContants.DEFAULT_PAGE_NUMBER, required = false) int page,
			@RequestParam(value = "limit", defaultValue = SystemContants.DEFAULT_PAGE_SIZE, required = false) int limit,
			@RequestParam(value = "sortBy", defaultValue = SystemContants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortName", defaultValue = SystemContants.DEFAULT_SORT_DIRECTION, required = false) String sortName) {

		BookDTO bookDTO = new BookDTO();
		bookDTO.setPage(page);
		bookDTO.setLimit(limit);
		bookDTO.setSortBy(sortBy);
		bookDTO.setSortBy(sortName);
		if (keyword != null) {
			bookDTO.setTotalItem(bookService.getToTalItemSearch(keyword));
			bookDTO.setTotalPage((int) Math.ceil((double) bookDTO.getTotalItem() / bookDTO.getLimit()));
			bookDTO.setListResult(bookService.search(keyword, page, limit, sortBy, sortName));
		} else {

			bookDTO.setTotalItem(bookService.getTotalItem());
			bookDTO.setTotalPage((int) Math.ceil((double) bookDTO.getTotalItem() / bookDTO.getLimit()));
			bookDTO.setListResult(bookService.findAll(page, limit, sortBy, sortName));
		}

		return bookDTO;
	}

	@GetMapping(value = "/api/bookList/{idCategory}")
	public BookDTO showBookByCategory(@PathVariable("idCategory") int idCategory) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setListResult(bookService.findAllByIdCategory(idCategory));
		return bookDTO;
	}

	@DeleteMapping(value = "/api/book")
	public int deleteDTO(@RequestBody int ids[]) {
		int result = bookService.delete(ids);
		return result;

	}
}

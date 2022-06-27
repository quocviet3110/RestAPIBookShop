package poly.bookshop.api;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import poly.bookshop.dto.BookImageDTO;
import poly.bookshop.service.IBookImageService;

@CrossOrigin
@RestController
public class BookImageAPI {
	@Autowired
	private IBookImageService bookImageService;
	@Autowired 
	private Cloudinary cloudinary;
	
	@PostMapping(value = "/bookImage",consumes = { "multipart/form-data", "application/json" })
	public BookImageDTO createImageBook(@RequestParam MultipartFile image,@RequestParam String name,@RequestParam int idBook) {
		
		BookImageDTO model = new BookImageDTO();
		model.setIdBook(idBook);
		model.setName(name);
		try {
		
			Map r = this.cloudinary.uploader().upload(image.getBytes(),
					ObjectUtils.asMap("resource_type", "auto"));
			model.setUrl((String) r.get("secure_url"));
		} catch (IOException e) {
		}
		
				
		return bookImageService.save(model);
	}
}

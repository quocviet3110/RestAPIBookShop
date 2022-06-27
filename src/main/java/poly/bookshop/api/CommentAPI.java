package poly.bookshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import poly.bookshop.dto.CommentDTO;
import poly.bookshop.service.ICommentService;

@CrossOrigin
@RestController
public class CommentAPI {
	@Autowired
	private ICommentService commentService;
	
	@GetMapping(value = "/api/comment/{idBook}")
	public CommentDTO showBookByCategory(@PathVariable("idBook") int idBook) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setListResult(commentService.findAllByIdBook(idBook));
		return commentDTO;
	}
	@PostMapping(value = "/api/comment")
	public CommentDTO createBook(@RequestBody CommentDTO model) {
		return commentService.save(model);
	}
	@DeleteMapping(value = "/api/comment")
	public int deleteDTO(@RequestBody int ids[]) {
		int result = commentService.delete(ids);
		return result;

	}
}

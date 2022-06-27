package poly.bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poly.bookshop.dto.CommentDTO;

@Service
public interface ICommentService {
	List<CommentDTO> findAllByIdBook(int idBook);

	CommentDTO save(CommentDTO model);

	int delete(int[] ids);

}

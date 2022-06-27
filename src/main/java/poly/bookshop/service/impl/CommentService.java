package poly.bookshop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.CommentDTO;
import poly.bookshop.entity.BookEntity;
import poly.bookshop.entity.CommentEntity;
import poly.bookshop.entity.CustomerEntity;
import poly.bookshop.repository.BookRepository;
import poly.bookshop.repository.CommentRepository;
import poly.bookshop.repository.CustomerRepository;
import poly.bookshop.service.ICommentService;

@Service
@Transactional
public class CommentService implements ICommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BookRepository bookRepository;

	private CommentDTO mapToDto(CommentEntity commentEntity) {
		CommentDTO commentDTO = mapper.map(commentEntity, CommentDTO.class);
		return commentDTO;
	}

	private CommentEntity mapToEntity(CommentDTO commentDTO) {
		CommentEntity commentEntity = mapper.map(commentDTO, CommentEntity.class);
		return commentEntity;
	}

	private CommentEntity mapToEntity(CommentEntity commentEntity, CommentDTO commentDTO) {
		commentEntity = mapper.map(commentDTO, CommentEntity.class);
		return commentEntity;
	}
	@Override
	public List<CommentDTO> findAllByIdBook(int idBook) {
		 List<CommentEntity> entities = commentRepository.findAllByIdBook(idBook);
			List<CommentDTO> results = new ArrayList<CommentDTO>();
			for(CommentEntity item : entities) {
				results.add(this.mapToDto(item));
			}
			return results;
	}

	@Override
	public CommentDTO save(CommentDTO model) {
		Date date = new Date();
		CommentEntity commentEntity = new CommentEntity();
		CustomerEntity customerEntity = customerRepository.findByUsername(model.getUsername());
		BookEntity bookEntity = bookRepository.findOneByID(model.getIdBook());
		
		if (model.getId() != null) {
			Optional<CommentEntity> oldOptional = commentRepository.findById(model.getId());
			CommentEntity old = oldOptional.get();
			commentEntity = this.mapToEntity(old, model);
			commentEntity.setCustomerComment(customerEntity);
			commentEntity.setBookComment(bookEntity);
			
		} else {
			commentEntity = this.mapToEntity(model);
			commentEntity.setCustomerComment(customerEntity);
			commentEntity.setBookComment(bookEntity);
			commentEntity.setDate(date);
		}
		return this.mapToDto(commentRepository.save(commentEntity));
	}

	@Override
	public int delete(int[] ids) {
		for(int item:ids) {
			commentRepository.deleteById(item);
		}
		return 0;
	}

}

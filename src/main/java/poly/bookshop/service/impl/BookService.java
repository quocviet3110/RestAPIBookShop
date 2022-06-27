package poly.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.BookDTO;
import poly.bookshop.entity.AuthorEntity;
import poly.bookshop.entity.BookEntity;
import poly.bookshop.entity.CategoryEntity;
import poly.bookshop.entity.PublisherEntity;
import poly.bookshop.repository.AuthorRepository;
import poly.bookshop.repository.BookRepository;
import poly.bookshop.repository.CategoryRepository;
import poly.bookshop.repository.PublisherRepository;
import poly.bookshop.service.IBookService;

@Service
@Transactional
public class BookService implements IBookService {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	@Autowired
	private ModelMapper mapper;

	private BookDTO mapToDto(BookEntity bookEntity) {
		BookDTO bookDTO = mapper.map(bookEntity, BookDTO.class);
		return bookDTO;
	}

	private BookEntity mapToEntity(BookDTO bookDTO) {
		BookEntity bookEntity = mapper.map(bookDTO, BookEntity.class);
		return bookEntity;
	}

	private BookEntity mapToEntity(BookEntity bookEntity, BookDTO bookDTO) {
		bookEntity = mapper.map(bookDTO, BookEntity.class);
		return bookEntity;
	}

	@Override
	public BookDTO save(BookDTO bookDTO) {
		BookEntity bookEntity = new BookEntity();
		Optional<AuthorEntity> authorOptional = authorRepository.findById(bookDTO.getIdAuthor());
		Optional<CategoryEntity> categoryOptional = categoryRepository.findById(bookDTO.getIdCategory());
		Optional<PublisherEntity> publisherOptional = publisherRepository.findById(bookDTO.getIdPublisher());
		AuthorEntity authorEntity = authorOptional.get();
		CategoryEntity categoryEntity = categoryOptional.get();
		PublisherEntity publisherEntity = publisherOptional.get();
		if (bookDTO.getId() != null) {
			Optional<BookEntity> oldOptional = bookRepository.findById(bookDTO.getId());
			BookEntity old = oldOptional.get();
			bookEntity = this.mapToEntity(old, bookDTO);
			bookEntity.setAuthors(authorEntity);
			bookEntity.setCategory(categoryEntity);
			bookEntity.setPublishers(publisherEntity);

		} else {
			bookEntity = this.mapToEntity(bookDTO);
			bookEntity.setAuthors(authorEntity);
			bookEntity.setCategory(categoryEntity);
			bookEntity.setPublishers(publisherEntity);

		}
		return this.mapToDto(bookRepository.save(bookEntity));

	}

	@Override
	public BookDTO findOneById(int id) {
		Optional<BookEntity> bookOptional = bookRepository.findById(id);
		return this.mapToDto(bookOptional.get());
	}


	@Override
	public int getTotalItem() {
		return (int) bookRepository.count();
	}

	@Override
	public List<BookDTO> findAll(int page, int limit, String sortBy, String sortName) {
		Sort sort = sortName.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
		 Pageable pageable = PageRequest.of(page-1, limit, sort);
	      Page<BookEntity> books = bookRepository.findAll(pageable);
		List<BookDTO> results = new ArrayList<BookDTO>();
		List<BookEntity> entity = books.getContent();
		for(BookEntity item : entity) {
			results.add(this.mapToDto(item));
		}
		return results;
	}

	@Override
	public int delete(int[] ids) {
		for(int item:ids) {
			bookRepository.deleteById(item);
		}
		return 0;
	}

	@Override
	public List<BookDTO> search(String keyword,int page, int limit, String sortBy, String sortName) {
		Sort sort = sortName.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
		 Pageable pageable = PageRequest.of(page-1, limit, sort);
	     Page<BookEntity> books = bookRepository.search(keyword,pageable);
		List<BookDTO> results = new ArrayList<BookDTO>();
		List<BookEntity> entity = books.getContent();
		for(BookEntity item : entity) {
			results.add(this.mapToDto(item));
		}
		return results;
	}

	@Override
	public int getToTalItemSearch(String keyword) {
		return  bookRepository.countSearch(keyword);
	}

	@Override
	public List<BookDTO> findAllByIdCategory(int idCategory) {
		 List<BookEntity> entities = bookRepository.findAllByIdCategory(idCategory);
			List<BookDTO> results = new ArrayList<BookDTO>();
			for(BookEntity item : entities) {
				results.add(this.mapToDto(item));
			}
			return results;
	}
}
package poly.bookshop.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.BookImageDTO;
import poly.bookshop.entity.BookEntity;
import poly.bookshop.entity.BookImageEntity;
import poly.bookshop.repository.BookImageRepository;
import poly.bookshop.repository.BookRepository;
import poly.bookshop.service.IBookImageService;

@Service
@Transactional
public class BookImageService implements IBookImageService {
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private BookImageRepository bookImageRepository;

	@Autowired
	private BookRepository bookRepository;


	private BookImageDTO mapToDto(BookImageEntity bookImageEntity) {
		BookImageDTO bookImageDTO = mapper.map(bookImageEntity, BookImageDTO.class);
		return bookImageDTO;
	}

	private BookImageEntity mapToEntity(BookImageDTO bookImageDTO) {
		BookImageEntity bookImageEntity = mapper.map(bookImageDTO, BookImageEntity.class);
		return bookImageEntity;
	}

	private BookImageEntity mapToEntity(BookImageEntity bookImageEntity, BookImageDTO bookImageDTO) {
		bookImageEntity = mapper.map(bookImageDTO, BookImageEntity.class);
		return bookImageEntity;
	}

	@Override
	public BookImageDTO save(BookImageDTO bookImageDTO) {
		BookImageEntity bookImageEntity = new BookImageEntity();
		Optional<BookEntity> optionalBook = bookRepository.findById(bookImageDTO.getIdBook());
		BookEntity bookEntity = optionalBook.get();
		if (bookImageDTO.getId() != null) {
			Optional<BookImageEntity> optionalBookImage = bookImageRepository.findById(bookImageDTO.getId());
			BookImageEntity old = optionalBookImage.get();
			bookImageEntity = this.mapToEntity(old, bookImageDTO);
			bookImageEntity.setBooks(bookEntity);

		} else {
			bookImageEntity = this.mapToEntity(bookImageDTO);
			bookImageEntity.setBooks(bookEntity);
		}
		return this.mapToDto(bookImageRepository.save(bookImageEntity));
	}

	@Override
	public BookImageDTO findOneById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookImageDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

}

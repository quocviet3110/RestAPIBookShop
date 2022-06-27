package poly.bookshop.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.BookImageDTO;

@Service
public interface IBookImageService {
	BookImageDTO save(BookImageDTO bookImageDTO);
	BookImageDTO findOneById(int id);
	List<BookImageDTO>  findAll(Pageable pageable);
	int getTotalItem();	
	int delete(int ids[]);
}

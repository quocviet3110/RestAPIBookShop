package poly.bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poly.bookshop.dto.BookDTO;

@Service
public interface IBookService {
	BookDTO save(BookDTO bookDTO);
	BookDTO findOneById(int id);
	List<BookDTO>  findAll(int pageNo, int pageSize, String sortBy, String sortName);
	int getTotalItem();	
	int delete(int ids[]);
	List<BookDTO> search(String keyword,int page, int limit, String sortBy, String sortName);
	int getToTalItemSearch(String keyword);
	List<BookDTO> findAllByIdCategory(int idCategory);
}

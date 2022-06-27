package poly.bookshop.service;

import java.util.List;

import poly.bookshop.dto.CategoryDTO;

public interface ICategoryService {
	List<CategoryDTO> findAll();
}

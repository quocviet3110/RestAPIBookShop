package poly.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.CategoryDTO;
import poly.bookshop.entity.CategoryEntity;
import poly.bookshop.repository.CategoryRepository;
import poly.bookshop.service.ICategoryService;

@Service
@Transactional
public class CategoryService implements ICategoryService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	private CategoryDTO mapToDto(CategoryEntity categoryEntity) {
		CategoryDTO categoryDTO = mapper.map(categoryEntity, CategoryDTO.class);
		return categoryDTO;
	}

	private CategoryEntity mapToEntity(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = mapper.map(categoryDTO, CategoryEntity.class);
		return categoryEntity;
	}

	private CategoryEntity mapToEntity(CategoryEntity categoryEntity, CategoryDTO categoryDTO) {
		 categoryEntity = mapper.map(categoryDTO, CategoryEntity.class);
		return categoryEntity;
	}
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> result = new ArrayList<CategoryDTO>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for(CategoryEntity item : entities) {
			result.add(this.mapToDto(item));
		}
		return result;
	}

}

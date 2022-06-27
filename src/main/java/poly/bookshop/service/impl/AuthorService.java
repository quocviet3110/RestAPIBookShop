package poly.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.AuthorDTO;
import poly.bookshop.dto.CategoryDTO;
import poly.bookshop.entity.AuthorEntity;
import poly.bookshop.entity.CategoryEntity;
import poly.bookshop.repository.AuthorRepository;
import poly.bookshop.service.IAuthorService;

@Service
@Transactional
public class AuthorService implements IAuthorService {
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private AuthorRepository authorRepository;

	private AuthorDTO mapToDto(AuthorEntity authorEntity) {
		AuthorDTO authorDTO = mapper.map(authorEntity, AuthorDTO.class);
		return authorDTO;
	}

	private AuthorEntity mapToEntity(AuthorDTO authorDTO) {
		AuthorEntity authorEntity = mapper.map(authorDTO, AuthorEntity.class);
		return authorEntity;
	}

	private AuthorEntity mapToEntity(AuthorEntity authorEntity, AuthorDTO authorDTO) {
		authorEntity = mapper.map(authorDTO, AuthorEntity.class);
		return authorEntity;
	}

	@Override
	public List<AuthorDTO> findAll() {
		List<AuthorDTO> result = new ArrayList<AuthorDTO>();
		List<AuthorEntity> entities = authorRepository.findAll();
		for(AuthorEntity item : entities) {
			result.add(this.mapToDto(item));
		}
		return result;
	}

}

package poly.bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poly.bookshop.dto.AuthorDTO;

@Service
public interface IAuthorService {
	List<AuthorDTO> findAll();
}

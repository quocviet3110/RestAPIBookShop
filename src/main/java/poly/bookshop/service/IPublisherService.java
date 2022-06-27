package poly.bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poly.bookshop.dto.PublisherDTO;

@Service
public interface IPublisherService {
	List<PublisherDTO> findAll();
	PublisherDTO findOneByIdBook(int idBook);
}

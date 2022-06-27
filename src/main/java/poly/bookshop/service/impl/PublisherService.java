package poly.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.PublisherDTO;
import poly.bookshop.entity.PublisherEntity;
import poly.bookshop.repository.PublisherRepository;
import poly.bookshop.service.IPublisherService;

@Service
@Transactional
public class PublisherService implements IPublisherService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	private PublisherDTO mapToDto(PublisherEntity publisherEntity) {
		PublisherDTO publisherDTO = mapper.map(publisherEntity, PublisherDTO.class);
		return publisherDTO;
	}

	private PublisherEntity mapToEntity(PublisherDTO publisherDTO) {
		PublisherEntity publisherEntity = mapper.map(publisherDTO, PublisherEntity.class);
		return publisherEntity;
	}

	private PublisherEntity mapToEntity(PublisherEntity publisherEntity, PublisherDTO publisherDTO) {
		 publisherEntity = mapper.map(publisherDTO, PublisherEntity.class);
		return publisherEntity;
	}
	@Override
	public List<PublisherDTO> findAll() {
		List<PublisherDTO> result = new ArrayList<PublisherDTO>();
		List<PublisherEntity> entities = publisherRepository.findAll();
		for(PublisherEntity item : entities) {
			result.add(this.mapToDto(item));
		}
		return result;
	}

	@Override
	public PublisherDTO findOneByIdBook(int idBook) {	
		return this.mapToDto(publisherRepository.findOneByIdBook(idBook));
	}

}

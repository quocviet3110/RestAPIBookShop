package poly.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.PayInDetailDTO;
import poly.bookshop.entity.BookEntity;
import poly.bookshop.entity.PayInDetailEntity;
import poly.bookshop.entity.PayInEntity;
import poly.bookshop.repository.BookRepository;
import poly.bookshop.repository.PayInDetailRepository;
import poly.bookshop.repository.PayInRepository;
import poly.bookshop.service.IPayInDetailService;
@Service
@Transactional
public class PayInDetailService implements IPayInDetailService {
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PayInDetailRepository payInDetailRepository;
	@Autowired
	private PayInRepository payInRepository;
	@Autowired
	private BookRepository bookRepository;
	
	private PayInDetailDTO mapToDtoDetail(PayInDetailEntity payInDetailEntity) {
		PayInDetailDTO payInDetailDTO = mapper.map(payInDetailEntity, PayInDetailDTO.class);
		return payInDetailDTO;
	}
	private PayInDetailEntity mapToEntity(PayInDetailDTO payInDetailDTO) {
		PayInDetailEntity payInDetailEntity = mapper.map(payInDetailDTO, PayInDetailEntity.class);
		return payInDetailEntity;
	}
	@Override
	public PayInDetailDTO save(PayInDetailDTO model) {
		PayInDetailEntity payInDetailEntity = new PayInDetailEntity();
		PayInEntity payInEntity = payInRepository.getById(model.getId());
		BookEntity bookEntity = bookRepository.getById(model.getBookID());
		payInDetailEntity = this.mapToEntity(model);
		payInDetailEntity.setPayInDetail(payInEntity);
		payInDetailEntity.setBookPayIn(bookEntity);
		
		return this.mapToDtoDetail(payInDetailRepository.save(payInDetailEntity));
	}

	@Override
	public List<PayInDetailDTO> findAll(int page, int limit, String sortBy, String sortName) {
		Sort sort = sortName.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
		 Pageable pageable = PageRequest.of(page-1, limit, sort);
	      Page<PayInDetailEntity> page2 = payInDetailRepository.findAll(pageable);
		List<PayInDetailDTO> results = new ArrayList<PayInDetailDTO>();
		List<PayInDetailEntity> entity = page2.getContent();
		for(PayInDetailEntity item : entity) {
			results.add(this.mapToDtoDetail(item));
		}
		return results;
	}
	@Override
	public List<PayInDetailDTO> findAllByID(int id) {
		 	List<PayInDetailEntity> entity  = payInDetailRepository.findAllByID(id);
			List<PayInDetailDTO> results = new ArrayList<PayInDetailDTO>();
			for(PayInDetailEntity item : entity) {
				results.add(this.mapToDtoDetail(item));
			}
			return results;
	}

}

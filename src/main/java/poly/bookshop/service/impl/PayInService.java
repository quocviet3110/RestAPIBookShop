package poly.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.PayInDTO;
import poly.bookshop.entity.PayInEntity;
import poly.bookshop.entity.StaffEntity;
import poly.bookshop.entity.SupplierEntity;
import poly.bookshop.repository.PayInRepository;
import poly.bookshop.repository.StaffRepository;
import poly.bookshop.repository.SupplierRepository;
import poly.bookshop.service.IPayInService;

@Service
@Transactional
public class PayInService implements IPayInService {
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PayInRepository payInRepository;

	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private SupplierRepository supplierRepository;

	private PayInDTO mapToDto(PayInEntity payInEntity) {
		PayInDTO payInDTO = mapper.map(payInEntity, PayInDTO.class);
		return payInDTO;
	}

	private PayInEntity mapToEntity(PayInDTO payInDTO) {
		PayInEntity payInEntity = mapper.map(payInDTO, PayInEntity.class);
		return payInEntity;
	}

	private PayInEntity mapToEntity(PayInEntity payInEntity, PayInDTO payInDTO) {
		payInEntity = mapper.map(payInDTO, PayInEntity.class);
		return payInEntity;
	}

	@Override
	public PayInDTO save(PayInDTO payInDTO) {
		PayInEntity payInEntity = new PayInEntity();
		StaffEntity staffEntity = staffRepository.findByUsernamr(payInDTO.getUsername());
		Optional<SupplierEntity> supplierOptional = supplierRepository.findById(payInDTO.getIdSupplier());
		SupplierEntity supplierEntity = supplierOptional.get();
		if (payInDTO.getId() != null) {
			Optional<PayInEntity> oldOptional = payInRepository.findById(payInDTO.getId());
			PayInEntity old = oldOptional.get();
			payInEntity = this.mapToEntity(old, payInDTO);
			payInEntity.setStaffPayIn(staffEntity);
			payInEntity.setSupplierPayIn(supplierEntity);

		}else {
			payInEntity = this.mapToEntity(payInDTO);
			payInEntity.setStaffPayIn(staffEntity);
			payInEntity.setSupplierPayIn(supplierEntity);
		}
		return this.mapToDto(payInRepository.save(payInEntity));
	}

	@Override
	public PayInDTO findOneById(int id) {
		Optional<PayInEntity> payInOptional = payInRepository.findById(id);
		return this.mapToDto(payInOptional.get());
	}

	

	@Override
	public int getTotalItem() {
		return (int) payInRepository.count();
	}

	@Override
	public int delete(int[] ids) {
		for(int item : ids) {
			payInRepository.deleteById(item);
		}
		return 0;
	}

	@Override
	public List<PayInDTO> findAll(int page, int limit, String sortBy, String sortName) {
		Sort sort = sortName.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
		 Pageable pageable = PageRequest.of(page-1, limit, sort);
	      Page<PayInEntity> payIn = payInRepository.findAll(pageable);
		List<PayInDTO> results = new ArrayList<>();
		List<PayInEntity> entity = payIn.getContent();
		for(PayInEntity item : entity) {
			results.add(this.mapToDto(item));
		}
		return results;
	}

	@Override
	public List<PayInDTO> search(String keyword, int page, int limit, String sortBy, String sortName) {
		Sort sort = sortName.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
		 Pageable pageable = PageRequest.of(page-1, limit, sort);
	     Page<PayInEntity> payIn = payInRepository.search(keyword,pageable);
		List<PayInDTO> results = new ArrayList<>();
		List<PayInEntity> entity = payIn.getContent();
		for(PayInEntity item : entity) {
			results.add(this.mapToDto(item));
		}
		return results;
	}

	@Override
	public Integer getToTalItemSearch(String keyword) {
		return  payInRepository.countSearch(keyword);
	}

}

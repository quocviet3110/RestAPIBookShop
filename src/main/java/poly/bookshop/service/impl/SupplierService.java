package poly.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.SupplierDTO;
import poly.bookshop.entity.SupplierEntity;
import poly.bookshop.repository.SupplierRepository;
import poly.bookshop.service.ISupplierService;

@Service
@Transactional
public class SupplierService implements ISupplierService {
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private ModelMapper mapper;

	private SupplierDTO mapToDto(SupplierEntity supplierEntity) {
		SupplierDTO supplierDTO = mapper.map(supplierEntity, SupplierDTO.class);
		return supplierDTO;
	}

	private SupplierEntity mapToEntity(SupplierDTO supplierDTO) {
		SupplierEntity supplierEntity = mapper.map(supplierDTO, SupplierEntity.class);
		return supplierEntity;
	}

	private SupplierEntity mapToEntity(SupplierEntity supplierEntity, SupplierDTO supplierDTO) {
		supplierEntity = mapper.map(supplierDTO, SupplierEntity.class);
		return supplierEntity;
	}

	@Override
	public SupplierDTO save(SupplierDTO supplierDTO) {
		SupplierEntity supplierEntity = new SupplierEntity();
		if (supplierDTO.getId() != null) {
			Optional<SupplierEntity> oldOptional = supplierRepository.findById(supplierDTO.getId());
			SupplierEntity old = oldOptional.get();
			supplierEntity = this.mapToEntity(old, supplierDTO);

		} else {
			supplierEntity = this.mapToEntity(supplierDTO);
		}
		SupplierDTO dto = this.mapToDto(supplierRepository.save(supplierEntity));
		return dto;
	}

	@Override
	public SupplierDTO findOneById(int id) {
		Optional<SupplierEntity> supplierOptinal = supplierRepository.findById(id);
		return this.mapToDto(supplierOptinal.get());
	}

	@Override
	public List<SupplierDTO> findAll() {
		List<SupplierDTO> result = new ArrayList<SupplierDTO>();
		List<SupplierEntity> entities = supplierRepository.findAll();
		for (SupplierEntity item : entities) {
			result.add(this.mapToDto(item));
		}
		return result;
	}
}

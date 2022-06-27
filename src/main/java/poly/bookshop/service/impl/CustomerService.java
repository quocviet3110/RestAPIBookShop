package poly.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.CustomerDTO;
import poly.bookshop.entity.CustomerEntity;
import poly.bookshop.entity.UserEntity;
import poly.bookshop.exception.DuplicateRecordException;
import poly.bookshop.repository.CustomerRepository;
import poly.bookshop.repository.UserRepository;
import poly.bookshop.service.ICusTomerService;

@Service
@Transactional
public class CustomerService implements ICusTomerService {
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	private CustomerDTO mapToDto(CustomerEntity customerEntity) {
		CustomerDTO customerDTO = mapper.map(customerEntity, CustomerDTO.class);
		return customerDTO;
	}

	private CustomerEntity mapToEntity(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = mapper.map(customerDTO, CustomerEntity.class);
		return customerEntity;
	}

	private CustomerEntity mapToEntity(CustomerEntity customerEntity, CustomerDTO customerDTO) {
		customerEntity = mapper.map(customerDTO, CustomerEntity.class);
		return customerEntity;
	}

	@Override
	public CustomerDTO save(CustomerDTO customerDTO) {
		if (customerRepository.existsByEmail( customerDTO.getEmail())) {
			throw new DuplicateRecordException("Email already exists in the system");
		}
		CustomerEntity customerEntity = new CustomerEntity();
		Optional<UserEntity> userOptional = userRepository.findById(customerDTO.getUsername());
		UserEntity userEntity = userOptional.get();
		if (customerDTO.getId() != null) {
			Optional<CustomerEntity> oldOptional = customerRepository.findById(customerDTO.getId());
			CustomerEntity old = oldOptional.get();
			customerEntity = this.mapToEntity(old, customerDTO);
			customerEntity.setUsers(userEntity);
		} else {
			customerEntity = this.mapToEntity(customerDTO);
			customerEntity.setUsers(userEntity);
		}
		return this.mapToDto(customerRepository.save(customerEntity));
	}

	@Override
	public CustomerDTO findOneById(int id) {
		Optional<CustomerEntity> cusOptional = customerRepository.findById(id);
		return this.mapToDto(cusOptional.get());
	}

	@Override
	public List<CustomerDTO> findAll(Pageable pageable) {
		List<CustomerDTO> result = new ArrayList<CustomerDTO>();
		List<CustomerEntity> entities = customerRepository.findAll(pageable).getContent();
		for (CustomerEntity item : entities) {
			result.add(this.mapToDto(item));
		}
		return result;
	}

	@Override
	public int getTotalItem() {
		return (int) customerRepository.count();
	}

	@Override
	public int delete(int[] ids) {
		for(int item :ids) {
			customerRepository.deleteById(item);
		}
		return 0;
	}

}

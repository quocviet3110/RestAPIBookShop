package poly.bookshop.service.impl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.UserDTO;
import poly.bookshop.entity.RoleEntity;
import poly.bookshop.entity.UserEntity;
import poly.bookshop.exception.DuplicateRecordException;
import poly.bookshop.repository.RoleRepository;
import poly.bookshop.repository.UserRepository;
import poly.bookshop.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	private UserDTO mapToDto(UserEntity userEntity) {
		UserDTO cartDTO = mapper.map(userEntity, UserDTO.class);
		return cartDTO;
	}

	private UserEntity mapToEntity(UserDTO userDTO) {
		UserEntity cartEntity = mapper.map(userDTO, UserEntity.class);
		return cartEntity;
	}

	private UserEntity mapToEntity(UserEntity userEntity, UserDTO cartDTO) {
		userEntity = mapper.map(cartDTO, UserEntity.class);
		return userEntity;
	}

	@Override
	public UserDTO save(UserDTO model) {

		if (userRepository.existsByUsername( model.getUsername())) {
			throw new DuplicateRecordException("Username already exists in the system");
		}

		UserEntity userEntity = new UserEntity();
		RoleEntity roleEntity = roleRepository.getById(model.getIdRole());

		if (model.getId() != null) {
			UserEntity old = userRepository.findOneByUsername(model.getUsername());
			userEntity = this.mapToEntity(old, model);
			userEntity.setPassword(bcryptEncoder.encode(model.getPassword()));
			userEntity.setRoleUser(roleEntity);
			userEntity.setStatus("1");
		} else {
			userEntity = this.mapToEntity(model);
			userEntity.setStatus("1");
			userEntity.setPassword(bcryptEncoder.encode(model.getPassword()));
			userEntity.setRoleUser(roleEntity);

		}
		return this.mapToDto(userRepository.save(userEntity));

	}

}

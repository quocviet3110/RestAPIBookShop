package poly.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.bookshop.dto.CartDTO;
import poly.bookshop.entity.BookEntity;
import poly.bookshop.entity.CartEntity;
import poly.bookshop.entity.CustomerEntity;
import poly.bookshop.repository.BookRepository;
import poly.bookshop.repository.CartRepository;
import poly.bookshop.repository.CustomerRepository;
import poly.bookshop.service.ICartService;

@Service
@Transactional
public class CartService implements ICartService {
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ModelMapper mapper;

	private CartDTO mapToDto(CartEntity cartEntity) {
		CartDTO cartDTO = mapper.map(cartEntity, CartDTO.class);
		return cartDTO;
	}

	private CartEntity mapToEntity(CartDTO cartDTO) {
		CartEntity cartEntity = mapper.map(cartDTO, CartEntity.class);
		return cartEntity;
	}

	private CartEntity mapToEntity(CartEntity cartEntity, CartDTO cartDTO) {
		cartEntity = mapper.map(cartDTO, CartEntity.class);
		return cartEntity;
	}

	@Override
	public List<CartDTO> findAllByIdCustomer(String username) {
		 List<CartEntity> entities = cartRepository.findAllByUsername(username);
			List<CartDTO> results = new ArrayList<CartDTO>();
			for(CartEntity item : entities) {
				results.add(this.mapToDto(item));
			}
			return results;
	}

	@Override
	public CartDTO save(CartDTO model) {
		/*
		 * if(cartRepository.existsByBook(model.getIdBook(),model.getCustomerCart().
		 * getUsername())) { throw new
		 * DuplicateRecordException("IDBook already exists in the system"); }
		 */
		CartEntity cartEntity = new CartEntity();
		CustomerEntity customerEntity = customerRepository.findByUsername(model.getUsername());
		BookEntity bookEntity = bookRepository.findOneByID(model.getIdBook());
		
		if (model.getId() != null) {
			Optional<CartEntity> oldOptional = cartRepository.findById(model.getId());
			CartEntity old = oldOptional.get();
			cartEntity = this.mapToEntity(old, model);
			cartEntity.setCustomerCart(customerEntity);
			cartEntity.setBookCart(bookEntity);

		} else {
			cartEntity = this.mapToEntity(model);
			cartEntity.setCustomerCart(customerEntity);
			cartEntity.setBookCart(bookEntity);

		}
		return this.mapToDto(cartRepository.save(cartEntity));
		
	}

	@Override
	public int delete(int[] ids) {
		for(int item:ids) {
			cartRepository.deleteById(item);
		}
		return 0;
	}

}

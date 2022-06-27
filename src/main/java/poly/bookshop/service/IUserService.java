package poly.bookshop.service;

import org.springframework.stereotype.Service;

import poly.bookshop.dto.UserDTO;

@Service
public interface IUserService {

	UserDTO save(UserDTO model);

}

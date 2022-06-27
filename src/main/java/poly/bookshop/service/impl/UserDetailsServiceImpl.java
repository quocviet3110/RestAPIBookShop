package poly.bookshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import poly.bookshop.constant.SystemContants;
import poly.bookshop.dto.UserDetailsImpl;
import poly.bookshop.entity.UserEntity;
import poly.bookshop.repository.UserRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUsername(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException("Account not found");
		}
		 return UserDetailsImpl.build(userEntity);
	}
	

}

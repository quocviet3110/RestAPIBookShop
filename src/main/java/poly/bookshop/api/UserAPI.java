package poly.bookshop.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.bookshop.dto.CartDTO;
import poly.bookshop.dto.UserDTO;
import poly.bookshop.dto.UserDetailsImpl;
import poly.bookshop.payload.LoginRequest;
import poly.bookshop.repository.RoleRepository;
import poly.bookshop.repository.UserRepository;
import poly.bookshop.service.IUserService;
import poly.bookshop.service.impl.UserService;
import poly.bookshop.util.JwtResponse;
import poly.bookshop.util.JwtUtils;

@RestController
public class UserAPI {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	IUserService userService;
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	 @PostMapping("/api/auth/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateJwtToken(userDetails);    
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());
	    return ResponseEntity.ok(new JwtResponse(jwt,
	                         userDetails.getUsername(),  
	                         roles));
	  }

		@PostMapping("/api/user")
		public UserDTO createBook(@RequestBody UserDTO model) {
			return userService.save(model);
		}
}

package poly.bookshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import poly.bookshop.dto.CartDTO;
import poly.bookshop.service.ICartService;

@CrossOrigin
@RestController
public class CartAPI {
	@Autowired
	private ICartService cartService;
	@GetMapping(value = "/api/cart/{username}")
	public CartDTO showCartByCustomer(@PathVariable("username") String username) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setListResult(cartService.findAllByIdCustomer(username));
		return cartDTO;
	}
	@ApiOperation(value = "Create user", response = CartDTO.class)
    @ApiResponses({
            @ApiResponse(code=400,message = "IDBOOK already exists in the system"),
            @ApiResponse(code=500,message = "")
    })
	@PostMapping(value = "/api/cart")
	public CartDTO createBook(@RequestBody CartDTO model) {
		return cartService.save(model);
	}
	@DeleteMapping(value = "/api/cart")
	public int deleteDTO(@RequestBody int ids[]) {
		int result = cartService.delete(ids);
		return result;

	}
}

package poly.bookshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	@RequestMapping(value = "/bookshop/admin", method = RequestMethod.GET)
	public String homePage() {
		return "admin/home";
	}
	
}

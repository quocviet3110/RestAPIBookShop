package poly.bookshop.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import poly.bookshop.util.MessageUtil;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/bookshop/trang-chu", method = RequestMethod.GET)
	public String homePage() {
		return "web/home";
	}
	@RequestMapping(value = "/bookshop/bookDetail", method = RequestMethod.GET)
	public String showProductDetail() {
		return "web/ProductDetail/infor";
	}
	@RequestMapping(value = "/bookshop/cart", method = RequestMethod.GET)
	public String showCart() {
		return "web/cart/cart";
	}
	@RequestMapping(value = "/bookshop/order", method = RequestMethod.GET)
	public String showOrder() {
		return "web/order/list";
	}
	@RequestMapping(value = "/bookshop/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("login/login");
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
	}
}

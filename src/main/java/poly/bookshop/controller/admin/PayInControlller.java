package poly.bookshop.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import poly.bookshop.util.MessageUtil;

@Controller
public class PayInControlller {
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/bookshop/admin/payIn/update",method = RequestMethod.GET )
	public ModelAndView update(@RequestParam(value = "id", required = false) Integer id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/payIn/edit");
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
	}
	
	@RequestMapping(value = "/bookshop/admin/payIn/list",method = RequestMethod.GET )
	public String showList() {
		return "/admin/payIn/list";
	}
	@RequestMapping(value = "/bookshop/admin/payInDetail/list",method = RequestMethod.GET )
	public String showDetailList(@RequestParam(value = "id", required = false) Integer id) {
		return "/admin/payInDetail/list";
	}
	@RequestMapping(value = "/bookshop/admin/payInDetail/update",method = RequestMethod.GET )
	public ModelAndView updateDetail(@RequestParam(value = "id", required = false) Integer id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/payInDetail/edit");
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
	}
}

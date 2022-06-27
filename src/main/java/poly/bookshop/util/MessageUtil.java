package poly.bookshop.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

	public Map<String, String> getMessage(String message) {
		Map<String, String> result = new HashMap<>();
		if (message.equals("update_success")) {
			result.put("message", "Chỉnh sửa thành công!");
			result.put("alert", "success");
		} else if (message.equals("insert_success")) {
			result.put("message", "Thêm mới thành công!");
			result.put("alert", "success");
		} else if (message.equals("delete_success")) {
			result.put("message", "Xóa thành công!");
			result.put("alert", "success");
		} else if (message.equals("error_system")) {
			result.put("message", "Lỗi thao tác!");
			result.put("alert", "danger");
		}else if (message.equals("signup_success")) {
			result.put("message", "Đăng ký thành công!");
			result.put("alert", "success");
		}else if (message.equals("delete_error")) {
			result.put("message", "Một số đối tượng bạn xóa đã được sử dụng!");
			result.put("alert", "danger");
		}else if (message.equals("login_error")) {
			result.put("message", "Tài khoản hoặc mật khẩu không đúng!");
			result.put("alert", "danger");
		}
		return result;
	}
}

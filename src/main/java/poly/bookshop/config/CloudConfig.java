package poly.bookshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudConfig {
	@Bean
	public CommonsMultipartResolver multipartResoler() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		return resolver;
	}
	@Bean 
	public Cloudinary cloudinary() {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name","thitracnghiem",
				"api_key","363469165254438",
				"api_secret","4bBSNJpgi1N2jkyofmbQ0sDpZMA",
				"secure",true));
		return cloudinary;
	}
}

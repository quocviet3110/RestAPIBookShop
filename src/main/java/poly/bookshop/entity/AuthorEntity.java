package poly.bookshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Author")
public class AuthorEntity extends BaseEntity {
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="AVATAR")
	private String avatar;
	
	@OneToMany(mappedBy = "authors")
	private List<BookEntity> books = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	

}

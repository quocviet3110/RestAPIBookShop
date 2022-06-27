package poly.bookshop.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name="Customer")
public class CustomerEntity extends BaseEntity {
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="AVATAR")
	private String avatar;
	
	@Column(name="GENDER")
	private int gender;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToOne
	@JoinColumn(name="USERNAME")
	private UserEntity users;
	
	@OneToMany(mappedBy = "customerCart")
	private List<CartEntity> cart= new ArrayList<CartEntity>();
	
	@OneToMany(mappedBy ="customerComment")
	private List<CommentEntity> comments= new ArrayList<CommentEntity>();
	
	@OneToMany(mappedBy = "customerOrder")
	private List<OrderEntity> order = new ArrayList<OrderEntity>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}

	

	public List<CartEntity> getCart() {
		return cart;
	}

	public void setCart(List<CartEntity> cart) {
		this.cart = cart;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public List<OrderEntity> getOrder() {
		return order;
	}

	public void setOrder(List<OrderEntity> order) {
		this.order = order;
	}
	
}

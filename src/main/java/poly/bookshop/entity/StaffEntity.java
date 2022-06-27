package poly.bookshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Staffs")
public class StaffEntity extends BaseEntity {
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="AVATAR")
	private String avatar;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToOne
	@JoinColumn(name="USERNAME")
	private UserEntity userStaff;
	
	
	@OneToMany(mappedBy = "staffPayIn")
	private List<PayInEntity> payIns = new ArrayList<>();


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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
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


	public UserEntity getUserStaff() {
		return userStaff;
	}


	public void setUserStaff(UserEntity userStaff) {
		this.userStaff = userStaff;
	}


	public List<PayInEntity> getPayIns() {
		return payIns;
	}


	public void setPayIns(List<PayInEntity> payIns) {
		this.payIns = payIns;
	}
	
	
}

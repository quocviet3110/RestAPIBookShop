package poly.bookshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class UserEntity {
	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="STATUS")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="ID_ROLE")
	private RoleEntity roleUser;
	
	@OneToOne(mappedBy = "users")
	private CustomerEntity customer; 
	
	@OneToOne(mappedBy = "userStaff")
	private StaffEntity staff;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleEntity getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(RoleEntity roleUser) {
		this.roleUser = roleUser;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public StaffEntity getStaff() {
		return staff;
	}

	public void setStaff(StaffEntity staff) {
		this.staff = staff;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	} 
	
	
}

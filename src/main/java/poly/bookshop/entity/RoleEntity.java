package poly.bookshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class RoleEntity extends BaseEntity {
	
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CODE")
	private String code;
	
	@OneToMany(mappedBy = "roleUser")
	private List<UserEntity> users = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
	
	
}

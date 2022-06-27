package poly.bookshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Supplier")
public class SupplierEntity extends BaseEntity{
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(mappedBy = "supplierPayIn")
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<PayInEntity> getPayIns() {
		return payIns;
	}

	public void setPayIns(List<PayInEntity> payIns) {
		this.payIns = payIns;
	}
	
	
}

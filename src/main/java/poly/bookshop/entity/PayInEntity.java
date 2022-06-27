package poly.bookshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name="pay_in")
public class PayInEntity extends BaseEntity {
	
	@Column(name="STATUS")
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="ID_STAFF")
	private StaffEntity staffPayIn;
	
	@ManyToOne
	@JoinColumn(name="ID_SUPPLIER")
	private SupplierEntity supplierPayIn;
	
	@OneToMany(mappedBy = "payInDetail")
	@JsonManagedReference
	private List<PayInDetailEntity> payInDetailEntities = new ArrayList<PayInDetailEntity>();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StaffEntity getStaffPayIn() {
		return staffPayIn;
	}

	public void setStaffPayIn(StaffEntity staffPayIn) {
		this.staffPayIn = staffPayIn;
	}

	public SupplierEntity getSupplierPayIn() {
		return supplierPayIn;
	}

	public void setSupplierPayIn(SupplierEntity supplierPayIn) {
		this.supplierPayIn = supplierPayIn;
	}

	public List<PayInDetailEntity> getPayInDetailEntities() {
		return payInDetailEntities;
	}

	public void setPayInDetailEntities(List<PayInDetailEntity> payInDetailEntities) {
		this.payInDetailEntities = payInDetailEntities;
	}


	
	
	
	
}

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
@Table(name="Orders")
public class OrderEntity extends BaseEntity {
	@Column(name="DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="STATUS")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="ID_CUSTOMER")
	private CustomerEntity customerOrder;
	
	@ManyToOne
	@JoinColumn(name="ID_STORE")
	private StoreEntity storeOrder;
	
	@OneToMany(mappedBy = "orderDetail")
	@JsonManagedReference
	private List<OrderDetailEntity> orderDetail = new ArrayList<OrderDetailEntity>();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CustomerEntity getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerEntity customerOrder) {
		this.customerOrder = customerOrder;
	}

	public StoreEntity getStoreOrder() {
		return storeOrder;
	}

	public void setStoreOrder(StoreEntity storeOrder) {
		this.storeOrder = storeOrder;
	}



	public List<OrderDetailEntity> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetailEntity> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

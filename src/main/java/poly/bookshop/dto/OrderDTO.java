package poly.bookshop.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OrderDTO extends AbstractDTO<OrderDTO> {
	
	private Date date;
	private CustomerDTO customerOrder;
	private StoreDTO storeOrder;
	private int idCustomer;
	private String status;
	private int idStore;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private List<OrderDetailDTO> listOrder = new ArrayList<>();
	
	public List<OrderDetailDTO> getListOrder() {
		return listOrder;
	}
	public void setListOrder(List<OrderDetailDTO> listOrder) {
		this.listOrder = listOrder;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public CustomerDTO getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(CustomerDTO customerOrder) {
		this.customerOrder = customerOrder;
	}

	public StoreDTO getStoreOrder() {
		return storeOrder;
	}
	public void setStoreOrder(StoreDTO storeOrder) {
		this.storeOrder = storeOrder;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public int getIdStore() {
		return idStore;
	}
	public void setIdStore(int idStore) {
		this.idStore = idStore;
	}
	
	
}

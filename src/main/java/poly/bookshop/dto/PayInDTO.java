package poly.bookshop.dto;

import java.util.Date;

public class PayInDTO extends AbstractDTO<PayInDTO>{
	private Date date;
	private int idStaff;
	
	private int idSupplier;
	
	private StaffDTO staffPayIn;
	
	private SupplierDTO supplierPayIn;
	
	private String username;
	
	private String status;
	
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
	public StaffDTO getStaffPayIn() {
		return staffPayIn;
	}
	public void setStaffPayIn(StaffDTO staffPayIn) {
		this.staffPayIn = staffPayIn;
	}
	public SupplierDTO getSupplierPayIn() {
		return supplierPayIn;
	}
	public void setSupplierPayIn(SupplierDTO supplierPayIn) {
		this.supplierPayIn = supplierPayIn;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	public int getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}
	
}

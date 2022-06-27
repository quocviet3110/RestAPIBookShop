package poly.bookshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class CartEntity extends BaseEntity {
	@Column(name="NUMBER")
	private int  number;
	
	@ManyToOne
	@JoinColumn(name="ID_CUSTOMER")
	private CustomerEntity customerCart;
	
	@ManyToOne
	@JoinColumn(name="ID_BOOK")
	private BookEntity bookCart;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public CustomerEntity getCustomerCart() {
		return customerCart;
	}

	public void setCustomerCart(CustomerEntity customerCart) {
		this.customerCart = customerCart;
	}

	public BookEntity getBookCart() {
		return bookCart;
	}

	public void setBookCart(BookEntity bookCart) {
		this.bookCart = bookCart;
	}
	
	
}

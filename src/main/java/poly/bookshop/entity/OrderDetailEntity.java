package poly.bookshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name="order_detail")
@IdClass(OrderKeyID.class)
public class OrderDetailEntity {
	@Id
	private int id;
	
	@Id
	private int bookID;
	
	@ManyToOne
	@JoinColumn(name="ID",insertable=false, updatable=false)
	@JsonBackReference
	private OrderEntity orderDetail;
	
	@ManyToOne
	@JoinColumn(name="ID_BOOK",insertable=false, updatable=false)
	private BookEntity bookOrder;
	
	@Column(name="NUMBER")
	private int number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public OrderEntity getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderEntity orderDetail) {
		this.orderDetail = orderDetail;
	}

	public BookEntity getBookOrder() {
		return bookOrder;
	}

	public void setBookOrder(BookEntity bookOrder) {
		this.bookOrder = bookOrder;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}

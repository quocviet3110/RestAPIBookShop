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
@Table(name="pay_in_detail")
@IdClass(PayInKeyID.class)
public class PayInDetailEntity {
	@Id
	private int id;
	
	@Id
	private int bookID;
	
	@ManyToOne
	@JoinColumn(name="ID",insertable=false, updatable=false)
	@JsonBackReference
	private PayInEntity payInDetail;
	
	@ManyToOne
	@JoinColumn(name="ID_BOOK",insertable=false, updatable=false)
	private BookEntity bookPayIn;
	
	@Column(name="NUMBER")
	private int number;
	
	@Column(name="PRICE")
	private float price;

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

	public PayInEntity getPayInDetail() {
		return payInDetail;
	}

	public void setPayInDetail(PayInEntity payInDetail) {
		this.payInDetail = payInDetail;
	}

	public BookEntity getBookPayIn() {
		return bookPayIn;
	}

	public void setBookPayIn(BookEntity bookPayIn) {
		this.bookPayIn = bookPayIn;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}

package poly.bookshop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Comment")
public class CommentEntity extends BaseEntity {
	@Column(name="THUMNAIL")
	private String content;
	
	@Column(name="DATE")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="ID_BOOK")
	private BookEntity bookComment;
	
	@ManyToOne
	@JoinColumn(name="ID_CUSTOMER")
	private CustomerEntity customerComment;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BookEntity getBookComment() {
		return bookComment;
	}

	public void setBookComment(BookEntity bookComment) {
		this.bookComment = bookComment;
	}

	public CustomerEntity getCustomerComment() {
		return customerComment;
	}

	public void setCustomerComment(CustomerEntity customerComment) {
		this.customerComment = customerComment;
	}
	
	
}

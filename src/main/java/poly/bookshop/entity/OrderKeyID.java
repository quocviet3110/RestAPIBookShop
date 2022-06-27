package poly.bookshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderKeyID implements Serializable {

	private static final long serialVersionUID = 576176629826040651L;

	@Column(name="ID")
	private int id;
	
	@Column(name="ID_BOOK")
	private int bookID;

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

	
}

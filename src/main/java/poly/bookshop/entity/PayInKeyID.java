package poly.bookshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PayInKeyID implements Serializable{

	private static final long serialVersionUID = -58987160092775208L;
	
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

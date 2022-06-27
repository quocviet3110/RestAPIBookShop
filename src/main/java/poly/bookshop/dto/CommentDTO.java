package poly.bookshop.dto;

import java.util.Date;

public class CommentDTO extends AbstractDTO<CommentDTO> {

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	private String content;
	private BookDTO bookComment;
	private CustomerDTO customerComment;
	private Date date;
	private String username;
	private int idBook;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BookDTO getBookComment() {
		return bookComment;
	}

	public void setBookComment(BookDTO bookComment) {
		this.bookComment = bookComment;
	}

	public CustomerDTO getCustomerComment() {
		return customerComment;
	}

	public void setCustomerComment(CustomerDTO customerComment) {
		this.customerComment = customerComment;
	}

}

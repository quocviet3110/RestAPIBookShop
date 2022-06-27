package poly.bookshop.dto;

public class OrderDetailDTO extends AbstractDTO<OrderDetailDTO> {
	private int idBook;
	private BookDTO bookOrder;
	private int number;
	
	
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public BookDTO getBookOrder() {
		return bookOrder;
	}
	public void setBookOrder(BookDTO bookOrder) {
		this.bookOrder = bookOrder;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}

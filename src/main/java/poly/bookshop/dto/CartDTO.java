package poly.bookshop.dto;

public class CartDTO extends AbstractDTO<CartDTO> {
	
	private int  number;
	private CustomerDTO customerCart;
	private BookDTO bookCart;
	private int idBook;
	private String username;
	
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public CustomerDTO getCustomerCart() {
		return customerCart;
	}
	public void setCustomerCart(CustomerDTO customerCart) {
		this.customerCart = customerCart;
	}
	public BookDTO getBookCart() {
		return bookCart;
	}
	public void setBookCart(BookDTO bookCart) {
		this.bookCart = bookCart;
	}
	
}

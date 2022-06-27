package poly.bookshop.dto;

import java.util.Date;

public class PriceDTO extends AbstractDTO<PriceDTO> {
	private Date dateBegin;
	private Date dateEnd;
	private BookDTO bookPrice;
	private float price;
	public Date getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public BookDTO getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(BookDTO bookPrice) {
		this.bookPrice = bookPrice;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}

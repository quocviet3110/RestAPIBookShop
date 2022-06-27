package poly.bookshop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Price")
public class PriceEntity extends BaseEntity {
	
	@Column(name="DATE_BEGIN")
	@Temporal(TemporalType.DATE)
	private Date dateBegin;
	
	@Column(name="DATE_END")
	@Temporal(TemporalType.DATE)
	private Date dateEnd;
	
	@ManyToOne
	@JoinColumn(name="ID_BOOK")
	private BookEntity bookPrice;
	
	@Column(name="PRICE")
	private float price;
	
}

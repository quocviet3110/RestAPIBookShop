package poly.bookshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class BookEntity extends BaseEntity {
	@Column(name="NAME")
	private String name;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="NUMBER")
	private int number;
	
	@Column(name="PRICE")
	private Float price;
	
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name="IMAGEURL")
	private String urlImage;
	
	@ManyToOne
	@JoinColumn(name="ID_AUTHOR")
	private AuthorEntity authors;
	
	@ManyToOne
	@JoinColumn(name="ID_PUBLISHER")
	private PublisherEntity publishers;
	
	@ManyToOne
	@JoinColumn(name="ID_CATEGORY")
	private CategoryEntity category;
	
	@OneToMany(mappedBy = "books")
	private List<BookImageEntity> bookImages = new ArrayList<>();
	
	@OneToMany(mappedBy = "bookCart")
	private List<CartEntity> carts = new ArrayList<>();
	
	@OneToMany(mappedBy = "bookComment")
	private List<CommentEntity> comments = new ArrayList<>();
	
	@OneToMany(mappedBy = "bookOrder")
	private List<OrderDetailEntity> orderDetails = new ArrayList<>();
	
	@OneToMany(mappedBy = "bookPrice")
	private List<PriceEntity> prices = new ArrayList<>();
	
	@OneToMany(mappedBy = "bookPayIn")
	private List<PayInDetailEntity> payIns = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public AuthorEntity getAuthors() {
		return authors;
	}

	public void setAuthors(AuthorEntity authors) {
		this.authors = authors;
	}

	public PublisherEntity getPublishers() {
		return publishers;
	}

	public void setPublishers(PublisherEntity publishers) {
		this.publishers = publishers;
	}

	
	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public List<BookImageEntity> getBookImages() {
		return bookImages;
	}

	public void setBookImages(List<BookImageEntity> bookImages) {
		this.bookImages = bookImages;
	}

	public List<CartEntity> getCarts() {
		return carts;
	}

	public void setCarts(List<CartEntity> carts) {
		this.carts = carts;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public List<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<PriceEntity> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceEntity> prices) {
		this.prices = prices;
	}

	public List<PayInDetailEntity> getPayIns() {
		return payIns;
	}

	public void setPayIns(List<PayInDetailEntity> payIns) {
		this.payIns = payIns;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	
}

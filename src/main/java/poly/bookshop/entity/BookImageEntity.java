package poly.bookshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book_image")
public class BookImageEntity extends BaseEntity {
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="URL")
	private String url;
	
	@ManyToOne
	@JoinColumn(name="ID_BOOKS")
	private BookEntity books;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BookEntity getBooks() {
		return books;
	}

	public void setBooks(BookEntity books) {
		this.books = books;
	}


	
}

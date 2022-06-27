package poly.bookshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Store")
public class StoreEntity extends BaseEntity {
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(mappedBy = "storeOrder")
	private List<OrderEntity> orders = new ArrayList<OrderEntity>();
}

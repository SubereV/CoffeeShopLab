package fudn.khangvo.lab231.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cafe_product")
@Data
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String content;
	private String picture;
	private double price;
	@Type(type = "date")
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menuId")@JsonIgnore
	private Menu menu;
	
	@PrePersist
	void create() {
		date = new Date();
	}

	public Product(String name, String content, String img, Menu menu,double price) {
		super();
		this.name = name;
		this.content = content;
		this.picture = img;
		this.menu = menu;
		this.price =price;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

package fudn.khangvo.lab231.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cafe_menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
	@Id	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "menu")
	@JsonIgnore
	private List<Product> products;

	public Menu(String name, String description){
		this.name = name;
		this.description = description;
	}

}

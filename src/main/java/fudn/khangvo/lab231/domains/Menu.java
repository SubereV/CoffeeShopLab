package fudn.khangvo.lab231.domains;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cafe_menu")
@Data
@NoArgsConstructor
public class Menu {
	@Id	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "menu")
	private List<Product> products;

}

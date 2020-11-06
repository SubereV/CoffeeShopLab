package fudn.khangvo.lab231.domains;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blogger")
@Data
@NoArgsConstructor
public class Blogger {
	@Id
	private String name;
	private String facebookLink;
	private String twitterLink;
	private String biography;
	private String address;
	private String phone;
	private String email;
	private String openingHours;
}

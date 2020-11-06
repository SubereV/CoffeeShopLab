package fudn.khangvo.lab231.domains;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Account {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
}

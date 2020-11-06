package fudn.khangvo.lab231.repositories;

import fudn.khangvo.lab231.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findByUsername(String username);
	
}

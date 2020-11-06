package fudn.khangvo.lab231.repositories;

import fudn.khangvo.lab231.domains.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {
	Menu findByName(String name);
}

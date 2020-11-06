package fudn.khangvo.lab231.repositories;

import fudn.khangvo.lab231.domains.Blogger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloggerRepository extends CrudRepository<Blogger, String> {

}

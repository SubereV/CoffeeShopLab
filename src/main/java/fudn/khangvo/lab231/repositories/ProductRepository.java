package fudn.khangvo.lab231.repositories;

import fudn.khangvo.lab231.domains.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	List<Product> findAllByOrderByPrice();
	List<Product> findTop2ByOrderByDateDesc();
}

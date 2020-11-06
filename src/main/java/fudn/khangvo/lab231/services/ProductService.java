package fudn.khangvo.lab231.services;

import fudn.khangvo.lab231.domains.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface ProductService {

	Optional<Product> findById(Integer id);

	List<Product> findAllByOrderByPrice();

	public Map<String, Set> getAllProduct();

	List<Product> findTop2ByOrderByDateDesc();

	<S extends Product> S save(S entity);
	
}

package fudn.khangvo.lab231.services;

import fudn.khangvo.lab231.domains.Product;
import fudn.khangvo.lab231.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findAllByOrderByPrice() {
		return productRepository.findAllByOrderByPrice();
	}

	@Override
	public Map<String, Set> getAllProduct() {
		Map<String,Set> data = new HashMap<>();
		Set<Map<String, String>> arrayObject = new HashSet<>();
		productRepository.findAll().forEach(product -> {
			Map<String,String> p = new HashMap<>();
			p.put("id", String.valueOf(product.getId()));
			p.put("name", product.getName());
			p.put("content", product.getContent());
			p.put("price", String.valueOf(product.getPrice()));
			p.put("picture", product.getPicture());
			p.put("date",String.valueOf(product.getDate()));
			p.put("menu", String.valueOf(product.getMenu().getId()));
			String url = "<img src=\""+product.getPicture()+"\" width=\"200px\">";
			p.put("picture-element",url);
			arrayObject.add(p);
		});
		data.put("data",arrayObject);
		return data;
	}

	@Override
	public List<Product> findTop2ByOrderByDateDesc() {
		return productRepository.findTop2ByOrderByDateDesc();
	}

	@Override
	public <S extends Product> S save(S entity) {
		return productRepository.save(entity);
	}

	@Override
	public void delete(Integer id){
		productRepository.deleteById(id);
	}
}

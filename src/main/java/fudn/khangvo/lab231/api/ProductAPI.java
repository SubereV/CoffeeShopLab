package fudn.khangvo.lab231.api;

import fudn.khangvo.lab231.domains.Product;
import fudn.khangvo.lab231.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("api/products")
public class ProductAPI {
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity products() {
		return ResponseEntity.ok(productService.getAllProduct());
	}
	//Todo: Check again
	@PostMapping("/insert")
	public ResponseEntity insert(Product product) {
		product.setDate(new Date());
		System.out.println(product);
		return ResponseEntity.ok().body(product);
	}
	//Todo: create edit api /edit Post

	//todo: delete api /delete Delete
}

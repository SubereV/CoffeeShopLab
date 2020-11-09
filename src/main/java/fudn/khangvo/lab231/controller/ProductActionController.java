package fudn.khangvo.lab231.controller;

import fudn.khangvo.lab231.domains.Product;
import fudn.khangvo.lab231.services.MenuService;
import fudn.khangvo.lab231.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/products")
public class ProductActionController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private ProductService productService;

    @PostMapping("/insert")
    public String insertProduct(String name, String content, double price, String picture, Integer menu) {
        Product product = new Product(name, content, picture, menuService.getMenuById(menu), price);
        productService.save(product);
        return "redirect:/product-management";
    }

    @PostMapping("/edit")
    public String editProduct(Integer id,String name, String content, double price, String picture, Integer menu) {
        Product product = new Product(name, content, picture, menuService.getMenuById(menu), price);
        product.setId(id);
        product.setDate(new Date());
        productService.save(product);
        return "redirect:/product-management";
    }
    @PostMapping("/delete")
    public String editProduct(Integer productId) {
        productService.delete(productId);
        return "redirect:/product-management";
    }

}

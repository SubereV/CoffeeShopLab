package fudn.khangvo.lab231.controller;

import fudn.khangvo.lab231.domains.Blogger;
import fudn.khangvo.lab231.services.BloggerService;
import fudn.khangvo.lab231.services.MenuService;
import fudn.khangvo.lab231.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
    ProductService productService;
	@Autowired
    MenuService menuService;
	@Autowired
    BloggerService bloggerService;
	@Value("${app.map}")
	String map;
	@GetMapping
	public String home(ModelMap model) {
		model.addAttribute("recentProduct", productService.findTop2ByOrderByDateDesc());
		model.addAttribute("page","home");
		return "Home";
	}

	@GetMapping("about")
	public String about(ModelMap model) {
		model.addAttribute("allMenu", menuService.findAll());
		model.addAttribute("page","about");
		return "About";
	}

	@GetMapping("find-cafe")
	public String FindCafe(ModelMap model) {
		model.addAttribute("map", map);
		model.addAttribute("page","other");
		return "FindCafe";
	}

	@GetMapping("admin")
	public String admin(ModelMap modelMap) {
		modelMap.addAttribute("menu_list", menuService.findAll());
		return "admin/index";
	}
	
	@GetMapping("login")
	public String login(@RequestParam(value = "error",defaultValue = "false") boolean loginError, final Model model) {
		return "admin/login";
	}

	@GetMapping("/product-management")
	public String products(ModelMap modelMap){
		modelMap.addAttribute("menu_list", menuService.findAll());
		return "admin/products";
	}
	@GetMapping("/menu-management")
	public String menusList(ModelMap modelMap){
		modelMap.addAttribute("menu_list", menuService.findAll());
		return "admin/menu";
	}


	@GetMapping("/error")
	public String error(){
		return "admin/404";
	}

	@ModelAttribute("blogger")
	public Blogger blogger() {
		return bloggerService.findById("Subere").get();
	}
}

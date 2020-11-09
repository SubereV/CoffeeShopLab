package fudn.khangvo.lab231.controller;

import fudn.khangvo.lab231.domains.Menu;
import fudn.khangvo.lab231.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuActionController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/insert")
    public String insert(String name, String description){
        menuService.insert(new Menu(name,description));
        return "redirect:/menu-management";
    }
    @PostMapping("/edit")
    public String edit(Integer id,String name, String description){
        menuService.insert(new Menu(id,name,description,null));
        return "redirect:/menu-management";
    }

    @PostMapping("/delete")
    public String delete(Integer productId){
        menuService.delete(productId);
        return "redirect:/menu-management";
    }
}

package fudn.khangvo.lab231.api;

import fudn.khangvo.lab231.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/menu")
public class MenuAPI {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity all(){
        Map<String, Object> data = new HashMap<>();
        data.put("data",menuService.findAll());
        return ResponseEntity.ok(data);
    }
}

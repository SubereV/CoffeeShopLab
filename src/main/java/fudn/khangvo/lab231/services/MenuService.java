package fudn.khangvo.lab231.services;

import fudn.khangvo.lab231.domains.Menu;

import java.util.List;

public interface MenuService {

	List<Menu> findAll();

	Menu findByName(String name);

	Menu getMenuById(Integer id);

	Integer insert(Menu menu);

    void delete(Integer id);
}

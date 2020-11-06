package fudn.khangvo.lab231.services;

import fudn.khangvo.lab231.domains.Menu;

import java.util.List;

public interface MenuService {

	List<Menu> findAll();

	Menu findByName(String name);

}

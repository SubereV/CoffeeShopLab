package fudn.khangvo.lab231.services;

import fudn.khangvo.lab231.domains.Menu;
import fudn.khangvo.lab231.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<Menu> findAll() {
		return (List<Menu>) menuRepository.findAll();
	}

	@Override
	public Menu findByName(String name) {
		return menuRepository.findByName(name);
	}
	
	
}

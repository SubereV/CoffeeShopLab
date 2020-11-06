package fudn.khangvo.lab231.services;

import fudn.khangvo.lab231.domains.Blogger;
import fudn.khangvo.lab231.repositories.BloggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BloggerServiceImpl implements BloggerService {

	@Autowired
	BloggerRepository bloggerRepository;

	@Override
	public Optional<Blogger> findById(String id) {
		return bloggerRepository.findById(id);
	}

}

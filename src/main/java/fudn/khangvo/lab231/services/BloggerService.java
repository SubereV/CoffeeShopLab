package fudn.khangvo.lab231.services;

import fudn.khangvo.lab231.domains.Blogger;

import java.util.Optional;

public interface BloggerService {

	Optional<Blogger> findById(String id);

}

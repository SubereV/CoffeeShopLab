package fudn.khangvo.lab231.services;

import fudn.khangvo.lab231.domains.Account;
import fudn.khangvo.lab231.domains.CustomUserDetails;
import fudn.khangvo.lab231.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account acc = accountRepository.findByUsername(username);
		if (acc == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(acc);
	}
}

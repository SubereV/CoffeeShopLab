package fudn.khangvo.lab231.config;

import fudn.khangvo.lab231.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userService;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Cung Cấp userDetailsService mình custom và password Encoder cho Spring
		// Security
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()// Cần có trước khi phân quyền
				.antMatchers("/admin","/product-management","/menu-management").authenticated()//
				.anyRequest().permitAll()//
				.and().formLogin().loginPage("/login").failureUrl("/login?error=true")// Đăng Nhập bằng form
				.defaultSuccessUrl("/admin").permitAll()// Đăng Nhập thành công
				.and()//
				.logout().permitAll();
		http
	      .csrf().disable();
	}
}

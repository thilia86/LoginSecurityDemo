package chatapp.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;



@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		            auth.inMemoryAuthentication()
		            .withUser(users.username("john").password("test123").roles("User"))
		            .withUser(users.username("tim").password("test123").roles("User","God"))
		            .withUser(users.username("geo").password("test123").roles("User","God","Admin"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasRole("User")
		.antMatchers("/leader/**").hasRole("God")
		.antMatchers("/admin/**").hasRole("Admin")
			.and().formLogin()
				  .loginPage("/showMyLoginPage")
				  .loginProcessingUrl("/authedicateTheUser")
				  .permitAll()
				  .and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	

	
	
	

}

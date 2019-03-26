package ca.sheridancollege;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginAccessDeniedHandler ladh;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("Giri").password("YPkeFMN8").roles("USER")
		.and()
		.withUser("Cristiano").password("Ronaldo").roles("Manager");
		
		// The type of security we are applying 
		// for every URL, we are applying security 
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		// Restrictions first and then the general access afterwards 
		http.authorizeRequests()
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/", "/js/**", "/css/**", "/img/**", "/**")
		.permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().invalidateHttpSession(true).clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll()
		.and()
		.exceptionHandling()
		.accessDeniedHandler(ladh);
	}

}

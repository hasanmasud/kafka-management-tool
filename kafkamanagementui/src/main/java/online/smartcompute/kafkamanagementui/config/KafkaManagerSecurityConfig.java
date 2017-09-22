package online.smartcompute.kafkamanagementui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class KafkaManagerSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String USER = "people";

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("masud").password("masud123").roles(USER);
		auth.inMemoryAuthentication().withUser("vikas").password("vikas123").roles(USER);
		auth.inMemoryAuthentication().withUser("prasada").password("prasada123").roles(USER);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/bootstrap/**").permitAll()
		.antMatchers("/bower_components/**").permitAll()
		.antMatchers("/elements/**").permitAll()
		.antMatchers("/imgs/**").permitAll()
		.antMatchers("/js/**").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/*.ico").permitAll()
		
		.antMatchers("/").hasRole(USER)
		.antMatchers("/home").hasRole(USER)
		.antMatchers("/rest/topics").hasRole(USER)
		.antMatchers("/rest/user").hasRole(USER)
		
		.and().formLogin().loginPage("/login")
		.usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/home")
		.failureUrl("/login.html?error=true").and().logout().logoutSuccessUrl("/login.html")
		.deleteCookies("JSESSIONID");
	}
	//
	// @Override
	// public void configure(AuthenticationManagerBuilder auth) throws Exception {
	// auth.ldapAuthentication().userDnPatterns("uid={0},ou=people").groupSearchBase("ou=groups")
	// .contextSource(contextSource()).passwordCompare().passwordEncoder(new
	// LdapShaPasswordEncoder())
	// .passwordAttribute("userPassword");
	// }
	//
	// @Bean
	// public DefaultSpringSecurityContextSource contextSource() {
	// return new
	// DefaultSpringSecurityContextSource(Arrays.asList("ldap://localhost:10389/"),
	// "dc=smartcompute,dc=online");
	// }

}

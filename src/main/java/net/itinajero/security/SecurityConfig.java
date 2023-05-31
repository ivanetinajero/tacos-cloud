package net.itinajero.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import net.itinajero.model.Usuario;
import net.itinajero.repository.IUsuariosRepository;

@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests(authorize -> authorize
						    
			// Asignar permisos a URLs por ROLES		
			.requestMatchers("/design", "/orders").hasRole("USER")
			//.requestMatchers("/none", "/other").hasAuthority("ADMINISTRADOR")
			
			// Las vistas publicas que no requieren autenticacion		
			.requestMatchers("/", "/**").permitAll()		
			//.requestMatchers("/css/**", "/images/**").permitAll()
	       
			// Todas las demas URLs de la Aplicacion requieren autenticacion
			//.anyRequest().authenticated()
		)			
		
		.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/authenticate").defaultSuccessUrl("/design", true).usernameParameter("user").passwordParameter("pwd"))
		.logout((logout) -> logout.logoutUrl("/salir"));
						
		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService(IUsuariosRepository usuariosRepo) {
	    return new UserDetailsService() {
	        @Override
	        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	            Usuario usuario = usuariosRepo.findByUsername(username);
	            if (usuario != null)
	                return usuario;
	            throw new UsernameNotFoundException("Usuario '" + username + "' no encontrado");
	        }
	    };
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * UserDetailsService is a functional interface and can be implemented as a lambda instead of as a full-blown implementation class.
	 * @param usuariosRepo
	 * @return
	 */
	/*
	@Bean
	UserDetailsService userDetailsService(IUsuariosRepository usuariosRepo) {
		return username -> {
			Usuario usuario = usuariosRepo.findByUsername(username);
			if (usuario != null)
				return usuario;
			throw new UsernameNotFoundException("Usuario '" + username + "' no encontrado");
		};
	}
	*/
	
	/*
	@Bean
	UserDetailsService userDetailsService(PasswordEncoder encoder) {
		List<UserDetails> usersList = new ArrayList<>();
		usersList.add(new User("itinajero", encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
		usersList.add(new User("admin", encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
		return new InMemoryUserDetailsManager(usersList);
	}
	*/	
	
}

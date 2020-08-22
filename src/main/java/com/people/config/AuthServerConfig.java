package com.people.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;



@Configuration
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
	@Value("${usuarioLogin}")
	private String usuarioLogin;
	
	@Value("${passwordLogin}")
	private String passwordLogin;
	

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
				.inMemory()
				.withClient("a")
				.secret(passwordEncoder().encode("a"))
				.authorities("ROLE_A","ROLE_B","ROLE_TRUSTED_CLIENT")
				.scopes("all")
				.authorizedGrantTypes("client_credentials")
				.and()
				.withClient(usuarioLogin)
				.secret(passwordEncoder().encode(passwordLogin))
				.authorities("ROLE_C")
				.scopes("all")
				.authorizedGrantTypes("client_credentials");
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		security.checkTokenAccess("permitAll()");
		security.checkTokenAccess("hasAuthority('ROLE_C')");
	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(4);
	}
}
package com.vaesoft.imp.uim.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
public class Oauth2ServerConfig {

	private static final String DEMO_RESOURCE_ID = "order";
	
	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
		@Override
		public void configure(ResourceServerSecurityConfigurer resources) {
			resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
		}
		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and().requestMatchers()
					.anyRequest().and().anonymous().and().authorizeRequests()
					// .antMatchers("/product/**").access("#oauth2.hasScope('select')
					// and hasRole('ROLE_USER')")
					.antMatchers("/order/**").hasAuthority("order");// 配置order访问控制，必须认证过后才可以访问
			// @formatter:on
			
		}
	}

	@Configuration
	@EnableAuthorizationServer
	protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
		@Autowired
		AuthenticationManager authenticationManager;
		@Autowired
		RedisConnectionFactory redisConnectionFactory;

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			// 配置两个客户端,一个用于password认证一个用于client认证
			clients.inMemory()
					.withClient("client_1").resourceIds(DEMO_RESOURCE_ID)
						.authorizedGrantTypes("client_credentials", "refresh_token").scopes("select").authorities("client")
					.secret("123456").and()
					.withClient("client_2").resourceIds(DEMO_RESOURCE_ID)
						.authorizedGrantTypes("password", "refresh_token").scopes("select").authorities("client")
					.secret("123456");
		}

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//			endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory))
//					.authenticationManager(authenticationManager);
			endpoints.tokenStore(new InMemoryTokenStore()).authenticationManager(authenticationManager);
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
			// 允许表单认证
			oauthServer.allowFormAuthenticationForClients();
		}

	}

}

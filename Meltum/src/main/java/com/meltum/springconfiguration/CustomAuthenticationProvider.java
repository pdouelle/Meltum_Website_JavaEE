package com.meltum.springconfiguration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.meltum.service.IService.IUserService;
import com.meltum.service.ServiceImpl.UserServiceImpl;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

		private IUserService userService = new UserServiceImpl();
	
		 @Override
		public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
			
			final String email = authentication.getName();
			final String password = authentication.getCredentials().toString();
			
			if (userService.authUser(email, password) != null) {
	            final List<GrantedAuthority> grantedAuths = new ArrayList<>();
	            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
	            return new UsernamePasswordAuthenticationToken(email, password, grantedAuths);
	        } else {
	            return null;
	        }
		}

		@Override
		public boolean supports(Class<?> authentication) {
			return authentication.equals(UsernamePasswordAuthenticationToken.class);
		}
}
package com.oguchok.isite.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oguchok.isite.persistence.model.Role;
import com.oguchok.isite.persistence.repository.UserRepository;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) 
		throws UsernameNotFoundException {
 
		com.oguchok.isite.persistence.model.User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user found with username: " +
					username);
		}
		
		List<GrantedAuthority> authorities = 
                                      buildUserAuthority(user.getRoles());
 
		return buildUserForAuthentication(user, authorities);
 
	}
 
	private User buildUserForAuthentication(com.oguchok.isite.persistence.model.User user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true,
				true, authorities);
	}
 
	private List<GrantedAuthority> buildUserAuthority(Collection<Role> userRoles) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		for (Role userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
		}
 
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
 
		return result;
	}

}

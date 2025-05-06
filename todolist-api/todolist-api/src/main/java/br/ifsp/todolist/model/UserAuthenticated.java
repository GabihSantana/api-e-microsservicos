package br.ifsp.todolist.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAuthenticated implements UserDetails {

	private final User user;

	public UserAuthenticated(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	/*
	 * Quando o SpringSecurity verificar as "Roles" que o usuario tem
	 */
	
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	
    	if(user.getRoles() == Role.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
    											new SimpleGrantedAuthority("ROLE_USER"));
    	
    	else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        /* return 
        		user.getRoles().stream()
                .map(role -> (GrantedAuthority) () -> role.getRoleName().name())
                .toList(); */
    }

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

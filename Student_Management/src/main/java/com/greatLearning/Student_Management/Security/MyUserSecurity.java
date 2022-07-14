package com.greatLearning.Student_Management.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatLearning.Student_Management.Model.Roles;
import com.greatLearning.Student_Management.Model.Users;

public class MyUserSecurity implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Users user;
	public MyUserSecurity(Users user) {
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Roles> roles = user.getAllRoles();
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(Roles role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
   		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

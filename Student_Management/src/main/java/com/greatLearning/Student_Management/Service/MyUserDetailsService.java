package com.greatLearning.Student_Management.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatLearning.Student_Management.Model.Users;
import com.greatLearning.Student_Management.Security.MyUserSecurity;
import com.greatLearning.Student_Management.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username+" Not Available");
		}
		else {
			return new MyUserSecurity(user);
		}
	}

}

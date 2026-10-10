package com.expensemanagement.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.expensemanagement.entity.User;
import com.expensemanagement.repository.UserRepository;

@Service
public class UserDetailsInfoService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {

		Optional<User> user = userRepository.findByName(username);
		return user.map(UserInfo::new)
				.orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
	}

}

package com.make.board.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.make.board.domain.Authority;
import com.make.board.domain.User;
import com.make.board.dto.UserDto;
import com.make.board.repository.UserRepository;
import com.make.board.util.SecurityUtil;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Transactional
	public User signup(UserDto userDto) {
		if(userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null){
			throw new RuntimeException("이미 가입되어 있는 유저입니다.");
		}
		
		Authority authority = Authority.builder()
									   .authorityName("ROLE_USER")
									   .build();
		
		User user = User.builder()
						.username(userDto.getUsername())
						.password(passwordEncoder.encode(userDto.getPassword()))
						.authorities(Collections.singleton(authority))
						.activated("1")
						.build();
		
		return userRepository.save(user);
						
	}
	
	@Transactional(readOnly = true)
	public Optional<User> getUserWithAuthorities(String username){
		return userRepository.findOneWithAuthoritiesByUsername(username);
	}
	
	@Transactional(readOnly = true)
	public Optional<User> getMyUserWithAuthorities(){
		return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
	}
	
}

package com.make.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.make.board.domain.User;


public interface UserRepository extends JpaRepository<User, Long>{

	@EntityGraph(attributePaths = "authorities")//쿼리가 수행될 때 Lazy 조회가 아니고  Eager 조회로 authorities 정보를 같이 가져옴
	Optional<User> findOneWithAuthoritiesByUsername(String username);
	
}

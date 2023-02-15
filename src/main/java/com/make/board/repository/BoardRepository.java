package com.make.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.make.board.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
	
	
	public Board findById(long seq);
	

}

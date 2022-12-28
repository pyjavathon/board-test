package com.make.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.make.board.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{

}

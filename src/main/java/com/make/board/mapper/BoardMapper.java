package com.make.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.make.board.domain.Board;
import com.make.board.dto.BoardDto;


@Mapper
public interface BoardMapper {
	
	List<Board> boardList();

}

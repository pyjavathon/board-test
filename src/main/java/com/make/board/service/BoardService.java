package com.make.board.service;

import java.util.List;
import java.util.Optional;

import com.make.board.domain.Board;
import com.make.board.dto.BoardDto;

public interface BoardService {
	
	
	
	public List<Board> boardList();

	public void boardSave(Board bt);

	public Board boardDetail(long seq);

}

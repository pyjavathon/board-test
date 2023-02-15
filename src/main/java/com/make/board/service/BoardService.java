package com.make.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.make.board.domain.Board;
import com.make.board.dto.BoardDto;

public interface BoardService {
	
	
	
	public List<Board> boardList();

	public void boardSave(Board bt, MultipartFile file)throws Exception;

	public Board boardDetail(long seq);

	public Board boardModify(long seq);

	public void boardDel(long seq);

}

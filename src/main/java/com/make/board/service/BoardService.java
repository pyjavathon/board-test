package com.make.board.service;


import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.make.board.domain.Board;

public interface BoardService {
	
	
	

	public void boardSave(Board bt, MultipartFile file)throws Exception;

	public Board boardDetail(long seq);

	public Board boardModify(long seq);

	public void boardDel(long seq);

	public Page<Board> boardList(int pNum, int searchN, String search);

	public Page<Board> boardList(int pNum);

}

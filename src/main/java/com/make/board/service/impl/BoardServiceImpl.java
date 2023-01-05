package com.make.board.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.board.domain.Board;
import com.make.board.dto.BoardDto;
import com.make.board.mapper.BoardMapper;
import com.make.board.repository.BoardRepository;
import com.make.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository br;
	
	@Autowired
	private BoardMapper bm;
	
	@Override
	public List<Board> boardList() {
		return bm.boardList();
	}

	@Override
	public void boardSave(Board bt) {
		br.save(bt);
		
	}

	@Override
	public Board boardDetail(long seq) {
		return br.findById(seq);
		
	}

	@Override
	public Board boardModify(long seq) {
		return br.findById(seq);
	}

}

package com.make.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.board.domain.Board;
import com.make.board.repository.BoardRepository;
import com.make.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository br;
	
	@Override
	public List<Board> boardList() {
		List<Board> list = br.findAll();
		System.out.println(list.toString());
		return list;
	}

}

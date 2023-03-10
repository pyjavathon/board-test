package com.make.board.service.impl;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public void boardSave(Board bt,MultipartFile file) throws Exception {
		
		String projectPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\files";
		
		UUID uuid = UUID.randomUUID();
		String fileName = uuid+"_"+file.getOriginalFilename();
		
		File saveFile = new File(projectPath,fileName);
		
		file.transferTo(saveFile);
		
		bt.setFilename(fileName);
		
		bt.setFilepath("/files/"+fileName);
		
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

	@Override
	public void boardDel(long seq) {
		br.deleteById(seq);
		
	}

	@Override
	public Page<Board> boardList(int pNum, int searchN, String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> boardList() {
		
		return br.findAll();
	}

}

package com.make.board.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.board.domain.Board;
import com.make.board.dto.BoardDto;
import com.make.board.service.BoardService;

@Controller
@RequestMapping(value= "board")    // /board 경로로 들어오는 경우 아래의 Method들로 분기될 수 있도록 설정
public class BoardController {
	@Autowired
	private BoardService boardService;
	
    // 게시판
	@PostMapping(value="/list")
	public String boardList(Model m, Board b){
		m.addAttribute("boardList", boardService.boardList());
		return "board/list"; 
	}
	
	@GetMapping(value = "/write")
	public String boardWrite() {
		return "board/write";
	}
	
	@PostMapping(value = "/write")
	public String boardSave(Board bt) {
		boardService.boardSave(bt);
		return "redirect:/board/list";
	}
	
	//글 상세보기
	@GetMapping(value = "/detail/{seq}")
	public String boardDetail(Model m,@PathVariable("seq") long seq) {
		Board b= boardService.boardDetail(seq);
		
		m.addAttribute("board", b);
		
		return "board/detail";
	}
}

package com.make.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.make.board.domain.Board;
import com.make.board.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value= "board")    // /board 경로로 들어오는 경우 아래의 Method들로 분기될 수 있도록 설정
public class BoardController {
	@Autowired
	private BoardService boardService;
	
    // 게시판
	@GetMapping(value="/list")
	public String boardList(Model m){
		List<Board> boardList = boardService.boardList();
		m.addAttribute("boardList", boardList);
		System.out.println(boardList);
		return "board/listV"; 
	}
}

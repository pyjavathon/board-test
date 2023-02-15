package com.make.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.make.board.domain.Board;
import com.make.board.service.BoardService;

@Controller
@RequestMapping(value= "board")    // /board 경로로 들어오는 경우 아래의 Method들로 분기될 수 있도록 설정
public class BoardController {
	@Autowired
	private BoardService boardService;
	
    //목록 조회
	@GetMapping(value="/list")
	public String boardList(Model m,@RequestParam(name = "pNum", defaultValue = "1")int pNum, String search, @RequestParam(defaultValue = "-1")int searchN){
		
		Page<Board> pageList = null;
		
		if(search != null) {
			pageList = boardService.boardList(pNum, searchN,search);
			String searchMsg = "\""+search+"\"검색 결과 ";
			m.addAttribute("searchMsg",searchMsg);
		}else {
			pageList = boardService.boardList(pNum);
		}
		List<Board> bList = pageList.getContent();
		int totaLPageCount = pageList.getTotalPages();
		long total = pageList.getTotalElements();
		
		m.addAttribute("bList", bList);
		m.addAttribute("totaLPageCount", totaLPageCount);
		m.addAttribute("total", total);
		
		int pageNum = 5;
		int begin = (pNum-1)/pageNum*pageNum+1;
		int end = begin + pageNum -1;
		if(end>totaLPageCount) end = totaLPageCount;
		
		m.addAttribute("begin",begin);
		m.addAttribute("end",end);
		m.addAttribute("search",search);
		m.addAttribute("searchN",searchN);
		
		return "board/list"; 
	}
	
	//글 쓰기
	@GetMapping(value = "/write")
	public String boardWrite() {
		return "board/write";
	}
	
	//글 쓰기
	@PostMapping(value = "/write")
	public String boardSave(Board bt,MultipartFile file, Model model) throws Exception{
		boardService.boardSave(bt, file);
		return "redirect:/board/list";
	}
	
	//글 상세보기
	@GetMapping(value = "/detail/{seq}")
	public String boardDetail(Model m,@PathVariable("seq") long seq) {
		Board b= boardService.boardDetail(seq);
		
		m.addAttribute("board", b);
		
		return "board/detail";
	}
	
	//글 수정
	@GetMapping(value = "/modify/{seq}")
	public String boardModify(@PathVariable("seq")long seq,Model m) {
		Board b= boardService.boardDetail(seq);
		
		m.addAttribute("board", b);
		
		return "board/modify";
		
	}
	
	@PutMapping(value = "modify/{seq}")
	public String boardModify(Board b,MultipartFile file) throws Exception {
		boardService.boardSave(b,file);
		return "redirect:/board/list";
	}
	
	//글 삭제
	@DeleteMapping(value = "/delete/{seq}")
	public String boardDel(@PathVariable("seq") long seq) {
		boardService.boardDel(seq);
		return "redirect:/board/list";
	}
}

package com.make.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BaseController {
	
	@RequestMapping("/helloPage")
	public String hello(Model m) {
		m.addAttribute("name", "hi ayeon");
		
		return "/common/hello";
	}
	
	

}

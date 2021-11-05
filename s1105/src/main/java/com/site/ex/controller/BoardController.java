package com.site.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.site.ex.dto.BoardDto;
import com.site.ex.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		// 전체게시글 가져오기
		List<BoardDto> list = boardService.list();
		model.addAttribute("list",list);
		return "board/list";
	}
}

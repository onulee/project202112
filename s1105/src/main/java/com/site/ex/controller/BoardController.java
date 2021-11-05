package com.site.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam int bid,Model model) {
		//게시글 1개 가져오기
		System.out.println("bid : "+bid);
		BoardDto bDto = boardService.boardOne(bid);
		model.addAttribute("bDto",bDto);
		return "board/content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int bid,Model model) {
		//게시글 삭제하기
		System.out.println("bid : "+bid);
		int result = boardService.boardDelete(bid);
		System.out.println("삭제 결과 : "+result);
		return "board/content_view";
	}
}

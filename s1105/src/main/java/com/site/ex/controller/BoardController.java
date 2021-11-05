package com.site.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		System.out.println("content_view bid : "+bid);
		BoardDto bDto = boardService.boardOne(bid);
		model.addAttribute("bDto",bDto);
		return "board/content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int bid) {
		//게시글 1개 삭제하기
		System.out.println("delete bid : "+bid);
		int result = boardService.delete(bid);
		System.out.println("result : "+result);
		return "redirect:./list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		//게시글 쓰기
		return "board/write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardDto boardDto) {
		//게시글 1개 저장:insert
		boardDto.setBupload("1.jpg");
		int result = boardService.write(boardDto);
		System.out.println("write 결과 : "+result);
		return "redirect:./list";
	}
	
	@GetMapping("/modify_view")
	public String modify_view(@RequestParam int bid,Model model) {
		//게시글 1개 가져오기
		System.out.println("modify_view bid : "+bid);
		BoardDto bDto = boardService.boardOne(bid);
		model.addAttribute("bDto",bDto);
		return "board/modify_view";
	}
	
	@RequestMapping("modify")
	public String modify(BoardDto boardDto) {
		System.out.println("modify bid : "+boardDto.getBid());
		//게시글 1개 저장:update
		int result = boardService.modify(boardDto);
		System.out.println("modify 결과 : "+result);
		return "redirect:./content_view?bid="+boardDto.getBid();
	}
	
	
}

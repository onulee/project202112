package com.site.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.ex.dto.CommentDto;
import com.site.ex.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@RequestMapping("/event")
	public String event() {
		//event 전체 게시글 가져오기
		
		return "event/event";
	}
	
	@RequestMapping("/event_view")
	public String event_view(@RequestParam int bid,Model model) {
		System.out.println("bid : "+bid);
		// 1개 : event게시글 1개를 가져오기
		// event게시글에 해당되는 하단댓글 가져오기
		List<CommentDto> clist = eventService.commmentList(bid);
		System.out.println("clist id : "+ clist.get(0).getCcontent());
		model.addAttribute("clist",clist);
		model.addAttribute("clistCount",clist.size());
		return "event/event_view";
	}
	
	@ResponseBody
	@RequestMapping("/commentWrite")
	public String commentWrite(CommentDto commentDto) {
		//event 전체 게시글 가져오기
		System.out.println("commentDto bid :"+commentDto.getBid());
		System.out.println("commentDto id :"+commentDto.getId());
		
		return "success";
	}
	
	

}

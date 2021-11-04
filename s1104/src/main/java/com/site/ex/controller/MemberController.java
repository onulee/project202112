package com.site.ex.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.ex.service.MemberService;
import com.site.ex.service.MemberServiceImpl;
import com.site.ex.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	//MemberService memberService = new MemberServiceImpl();
	
	@RequestMapping("/member/memberList")
	public String memberList(Model model) {
		List<Member> list = memberService.memberList();
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member/login") //로그인 페이지
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login") //로그인 id,pw확인메소드
	public String login(@RequestParam String id,@RequestParam String pw
			,Model model,HttpServletRequest request) {
		System.out.println("login post id : "+id);
		HttpSession session = request.getSession();
		//db확인
		if(id.equals("admin") && pw.equals("1111")) {
			session.setAttribute("session_id", id);
			session.setAttribute("session_nickName", "길동스");
			model.addAttribute("msg","1");
		}else {
			model.addAttribute("msg","0");
		}
		return "member/login";
	}

	@RequestMapping("/member/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:../index";
	}
	
	
	
}//class

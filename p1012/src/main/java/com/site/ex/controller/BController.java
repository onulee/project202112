package com.site.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex.service.BService;
import com.site.ex.service.BServiceList;
import com.site.ex.service.BServiceView;
import com.site.ex.service.BServiceWrite;


@WebServlet("*.do")
public class BController extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("doAction");
		//파일이름을 찾아야 함. - p1012/index.do
		String uri = request.getRequestURI();  //p1012/index.do
		int cPath = request.getContextPath().length(); //p1012 - 5
		String fileName = uri.substring(cPath); // /index.do
		String page="";
		BService bService=null;
		if(fileName.equals("/index.do")) {
			page="index.jsp";
		}else if(fileName.equals("/boardList.do")) {
			//dao -> 전체게시판글을 가져와야 함.
			// 객체선언  MVC - Service,Model
			bService = new BServiceList();
			// request에 list가 담겨짐.
			bService.execute(request, response);
			page="boardList.jsp";
		}else if(fileName.equals("/boardView.do")) {
			bService = new BServiceView();
			bService.execute(request, response);
			page="boardView.jsp";
		}else if(fileName.equals("/boardWrite.do")) {
		    page="boardWrite.jsp";	
		}else if(fileName.equals("/doBoardWrite.do")) {
			//bService객체선언
			bService = new BServiceWrite();
			System.out.println("controller : "+request.getParameter("bname"));
			//request 파리미터 데이터 값이 db저장됨.
			bService.execute(request, response);
			page="doBoardWrite.jsp";
		}
		
		
		//----------
		// 페이지 forward기능이 있음. sendRedirect-request,response신규리턴,dispatcher-기존request,response를 그대로 리턴
		//response.sendRedirect("index.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	
	}
	
	
	
	
	//--------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request,response);
	}
	
	

}

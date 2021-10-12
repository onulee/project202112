package com.site.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex.dao.BoardDao;
import com.site.ex.dto.BoardDto;

public class BServiceView implements BService {

	@Override //bid에 해당되는 게시글 가져오기
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//객체선언
		BoardDao bDao = new BoardDao();
		// 파라미터로 넘어온 bid값 저장
		int bid = Integer.parseInt(request.getParameter("bid"));
		//조회수 1증가
		bDao.updateBhit(bid);
		//dao에 있는 selectBoardView호출 -> BoardDto
		BoardDto bDto = bDao.selectBoardView(bid);
		request.setAttribute("bDto", bDto);
	}

}

package com.site.ex.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex.dao.BoardDao;
import com.site.ex.dto.BoardDto;

public class BServiceList implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao bDao = new BoardDao();
		//BoardDao의 selectBoardList호출 -> list가져옴.
		ArrayList<BoardDto> list = bDao.selectBoardList();
		request.setAttribute("list", list);

	}

}

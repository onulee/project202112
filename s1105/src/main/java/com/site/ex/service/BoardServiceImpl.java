package com.site.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.ex.dto.BoardDto;
import com.site.ex.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override //전체게시글 가져오기
	public List<BoardDto> list() {
		List<BoardDto> list = boardMapper.selectList();
		return list;
	}

}

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

	@Override //게시글 1개 가져오기
	public BoardDto boardOne(int bid) {
		// 조회수 1증가
		boardMapper.updateBhit(bid);
		BoardDto bDto = boardMapper.selectBoardOne(bid);
		return bDto;
	}

	@Override //게시글 1개 삭제하기
	public int delete(int bid) {
		System.out.println("serviceImpl bid : "+bid);
		int result = 0;
		result = boardMapper.boardDelete(bid);
		return result;
	}

	@Override //게시글 1개 저장
	public int modify(BoardDto boardDto) {
		int result = boardMapper.updateModify(boardDto);
		return result;
	}

	@Override //게시글 1개 저장:insert
	public int write(BoardDto boardDto) {
		int result = boardMapper.insertWrite(boardDto);
		return result;
	}


}

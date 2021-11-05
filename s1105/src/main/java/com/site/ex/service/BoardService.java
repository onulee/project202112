package com.site.ex.service;

import java.util.List;

import com.site.ex.dto.BoardDto;

public interface BoardService {

	//전체게시글 가져오기
	List<BoardDto> list();

	//게시글 1개 가져오기
	BoardDto boardOne(int bid);

	//게시글 1개 삭제하기
	int delete(int bid);

	//게시글 1개 저장
	int modify(BoardDto boardDto);

	//게시글 1개 저장:insert
	int write(BoardDto boardDto);

	

}

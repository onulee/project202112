package com.site.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.ex.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//전체게시글 가져오기
	List<BoardDto> selectList();

	//게시글 1개 가져오기
	BoardDto selectBoardOne(int bid);

	//게시글 삭제하기
	int boardDelete(int bid);

}

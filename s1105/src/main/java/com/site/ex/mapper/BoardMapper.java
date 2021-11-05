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
	// 조회수 1증가
	void updateBhit(int bid);

	//게시글 1개 삭제하기
	int boardDelete(int bid);

	//게시글 1개 저장
	int updateModify(BoardDto boardDto);

	//게시글 1개 저장:insert
	int insertWrite(BoardDto boardDto);


}

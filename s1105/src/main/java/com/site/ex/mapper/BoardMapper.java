package com.site.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.ex.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//전체게시글 가져오기
	List<BoardDto> selectList();

}

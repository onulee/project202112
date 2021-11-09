package com.site.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.ex.dto.CommentDto;

@Mapper
public interface EventMapper {

	// event게시글에 해당되는 하단댓글 가져오기
	List<CommentDto> selectCommmentList(int bid);

}

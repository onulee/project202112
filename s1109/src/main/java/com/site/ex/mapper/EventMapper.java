package com.site.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.ex.dto.CommentDto;

@Mapper
public interface EventMapper {

	// event게시글에 해당되는 댓글전체 가져오기
	List<CommentDto> selectCommmentList(int bid);

	//댓글추가
	void insertCommentWrite(CommentDto commentDto);

	//댓글1개 가져오기
	CommentDto selectCommentOne(int cno);

	//댓글 개수
	int selectCount(CommentDto commentDto);

	//댓글 삭제
	int deleteComment(int cno);

}

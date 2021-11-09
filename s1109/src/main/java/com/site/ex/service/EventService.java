package com.site.ex.service;

import java.util.List;

import com.site.ex.dto.CommentDto;

public interface EventService {

	// event게시글에 해당되는 하단댓글 가져오기
	List<CommentDto> commmentList(int bid);

}

package com.site.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.ex.dto.CommentDto;
import com.site.ex.mapper.EventMapper;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventMapper eventMapper;
	
	@Override // event게시글에 해당되는 하단댓글 가져오기
	public List<CommentDto> commmentList(int bid) {
		//댓글가져오기
		List<CommentDto> clist = eventMapper.selectCommmentList(bid);
		//댓글개수
		return clist;
	}

}

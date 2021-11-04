package com.site.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.ex.mapper.MemberMapper;
import com.site.ex.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override //전체회원정보
	public List<Member> memberList() {
		List<Member> list = memberMapper.selectMemberList();
		return null;
	}

}

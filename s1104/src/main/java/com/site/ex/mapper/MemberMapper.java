package com.site.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.ex.vo.Member;

@Mapper
public interface MemberMapper {

	//전체회원정보
	List<Member> selectMemberList();

}

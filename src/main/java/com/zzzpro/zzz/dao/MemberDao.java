package com.zzzpro.zzz.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zzzpro.zzz.dto.MemberDto;

@Mapper
public interface MemberDao {

	boolean idCheck(String m_id);

	boolean nickCheck(String m_nick);
	
	boolean emailCheck(String m_email);

	boolean join(MemberDto mDto);

	String login(MemberDto mDto);

	String getNick(String b_writer);
	
	
}

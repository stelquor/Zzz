package com.zzzpro.zzz.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zzzpro.zzz.dto.MemberDto;

@Mapper
public interface MemberDao {

	public boolean idCheck(String m_id);

	public boolean nickCheck(String m_nick);
	
	public boolean emailCheck(String m_email);

	public boolean join(MemberDto mDto);

	public String login(MemberDto mDto);

	
}

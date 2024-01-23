package com.zzzpro.zzz.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.zzzpro.zzz.dto.BoardDto;

@Mapper
public interface BoardDao {
	// Test용 더미 데이터
	public void insertDummyData(BoardDto bDto);

	public ArrayList<BoardDto> boardList(int limit);

	public BoardDto boardDetail(int b_num);

	public boolean writeSub(BoardDto bDto);

	public String getNick(String b_writer);
	
}

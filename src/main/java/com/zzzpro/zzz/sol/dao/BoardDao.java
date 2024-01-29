package com.zzzpro.zzz.sol.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.zzzpro.zzz.sol.dto.BoardDto;

@Mapper
public interface BoardDao {
	// Test용 더미 데이터
	public void insertDummyData(BoardDto bDto);

	public ArrayList<BoardDto> boardList(int limit);

	public BoardDto boardDetail(int b_num);

	public boolean writeSub(BoardDto bDto);

	public boolean unPwCheck(BoardDto bDto);
	
}

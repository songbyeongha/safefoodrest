package com.safefood.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.safefood.dto.Board;

@Mapper 
public interface HrmMapper {
	public List<Board> selectAll();
	public Board select(int id);
	public List<Board> pagingPageSelect(int page);
	public List<Board> selectByTitle(String title);
	public List<Board> selectByWriter(String writer);
	public List<Board> selectByContent(String content);
	public int hitUp(Board Board);
	public int insertBoard(Board Board);
	public int updateBoard(Board Board);
	public int deleteBoard(int id);
}

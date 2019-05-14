package com.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.dto.Board;
import com.ssafy.repository.HrmMapper;

@Service
@Transactional
public class HrmServiceImpl implements HrmService{

	@Autowired
	HrmMapper mapper;

	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public Board select(int id) {
		// TODO Auto-generated method stub
		return mapper.select(id);
	}

	@Override
	public List<Board> pagingPageSelect(int page) {
		// TODO Auto-generated method stub
		return mapper.pagingPageSelect(page);
	}

	@Override
	public List<Board> selectByTitle(String title) {
		// TODO Auto-generated method stub
		return mapper.selectByTitle(title);
	}

	@Override
	public List<Board> selectByContent(String content) {
		// TODO Auto-generated method stub
		return mapper.selectByContent(content);
	}

	@Override
	public int insertBoard(Board Board) {
		// TODO Auto-generated method stub
		return mapper.insertBoard(Board);
	}

	@Override
	public int updateBoard(Board Board) {
		// TODO Auto-generated method stub
		return mapper.updateBoard(Board);
	}

	@Override
	public int deleteBoard(int id) {
		// TODO Auto-generated method stub
		return mapper.deleteBoard(id);
	}

	@Override
	public int hitUp(Board Board) {
		// TODO Auto-generated method stub
		return mapper.hitUp(Board);
	}

	@Override
	public List<Board> selectByWriter(String writer) {
		// TODO Auto-generated method stub
		return mapper.selectByWriter(writer);
	}
	

}

package com.nxon.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.nxon.vo.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Inject
	private SqlSession sqlSession;
	
	//게시글 작성
	@Override
	public void write(BoardVO vo) throws Exception {
		sqlSession.insert("boardMapper.insert", vo);		
	}
	
	//게시글 목록
	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.list");
	}
	
	//게시글 작성
	@Override
	public BoardVO read(int bno) throws Exception {
		return sqlSession.selectOne("boardMapper.read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		sqlSession.update("boardMapper.update", vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("boardMapper.delete", bno);
	}	

}

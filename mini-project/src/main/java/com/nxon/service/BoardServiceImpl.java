package com.nxon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nxon.dao.BoardDao;
import com.nxon.vo.BoardVO;
import com.nxon.vo.Criteria;

@Service
public class BoardServiceImpl implements BoardService{	
	
	@Inject
	private BoardDao dao;
	
	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);		
	}

	@Override
	public List<BoardVO> list(Criteria cri) throws Exception {
		return dao.list(cri);
	}

	@Override
	public BoardVO read(int bno) throws Exception {		
		return dao.read(bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}	

	@Override
	public int listCount() throws Exception {
		return dao.listCount();
	}	
}

package com.nxon.service;

import java.util.List;

import com.nxon.vo.BoardVO;

public interface BoardService {
	
	//게시글 작성
	public void write(BoardVO vo) throws Exception;
	
	//게시글 목록
	public List<BoardVO> list() throws Exception;
	
	//게시글 상세보기
	public BoardVO read(int bno) throws Exception;
	
	//게시글 수정
	public void update(BoardVO vo) throws Exception;
	
	//게시글 삭제
	public void delete(int bno) throws Exception;
	
}
package com.nxon.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nxon.service.BoardService;
import com.nxon.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	// 게시판 글 작성 화면
	@RequestMapping(value = "/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");		
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVO vo) throws Exception{
		logger.info("write");		
		service.write(vo);		
		return "redirect:/board/list";
	}
	
	// 게시판 글 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		logger.info("list");		
		model.addAttribute("list", service.list());
		return "board/list";
	}
	
	//게사판 조회 
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(BoardVO vo, Model model) throws Exception{
		logger.info("read");		
		model.addAttribute("read", service.read(vo.getBno()));
		return "board/read";
	}
	
	//게시판 수정 화면
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(BoardVO vo, Model model) throws Exception{
		logger.info("updateView");
		model.addAttribute("update", service.read(vo.getBno()));
		return "board/updateView";
	}
	
	//게시판 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo) throws Exception {
		logger.info("update");
		service.update(vo);
		return "redirect:/board/list";		
	}	
	
	//게사판 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardVO vo) throws Exception {
		logger.info("delete");
		service.delete(vo.getBno());
		return "redirect:/board/list";
	}
	
	
}
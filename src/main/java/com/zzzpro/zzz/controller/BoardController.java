package com.zzzpro.zzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zzzpro.zzz.dto.BoardDto;
import com.zzzpro.zzz.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	private BoardService bSer;
	
	@GetMapping("/board/list")
	public String boardList(int page, Model model) {
		log.info(" ========== > controller - boardList < ==========");
		bSer.boardList(page, model);
		return "boardList";
	}
	
	@GetMapping("/board/detail")
	public String boardDetail(BoardDto bDto, Model model) {
		log.info(" ========== > controller - boardDetail < ==========");
		if(bSer.boardDetail(bDto, model)) {
			return "boardDetail";
		}
		return "boardList";
	}
	
	@GetMapping("/board/boardWrite")
	public String boardWrite(Model model) {
		log.info(" ========== > controller - bWrite < ==========");
		return "boardWrite";
	}
	
	@GetMapping("/board/writeSub")
	public String writeSub(BoardDto bDto, RedirectAttributes ra) {	
		log.info(" ========== > controller - writeSub < =========={}",bDto);
		bSer.writeSub(bDto, ra);
		return "redirect:/board/list?page=1";
	}
}

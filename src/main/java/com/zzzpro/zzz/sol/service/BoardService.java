package com.zzzpro.zzz.sol.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zzzpro.zzz.sol.dao.BoardDao;
import com.zzzpro.zzz.sol.dao.MemberDao;
import com.zzzpro.zzz.sol.dto.BoardDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	
	@Autowired
	private BoardDao bDao;
	
	public boolean boardList(int page, Model model) {
		log.info(" ========== > service - boardList: "+page+" < ==========");
		int limit = (page-1)*10;
		ArrayList<BoardDto> bList = bDao.boardList(limit);
		if(bList.size()!=0) {
			model.addAttribute("bList", bList);
			return true;
		}
		return false;
	}

	public boolean boardDetail(BoardDto bDto, Model model) {
		log.info(" ========== > service - boardList: "+bDto.getB_num()+" < ==========");
		bDto = bDao.boardDetail(bDto.getB_num());
		System.out.println(bDto);
		if(bDto.getB_date()!="") {
			if(bDto.getUnnamed()==1) {
				bDto.setB_writer(bDto.getB_writerNick());
			}
			model.addAttribute("bDto", bDto);
			return true;
		}
		return false;
	}

	public boolean writeSub(BoardDto bDto, RedirectAttributes ra) {
		log.info(" ========== > service - writeSub: "+bDto.getB_writer()+" < ==========");
		System.out.println(bDto);
		if(bDto.getB_writerNick()=="") {
			System.out.println(bDto.getB_writer());
			bDto.setB_writerNick(bDao.getNick(bDto.getB_writer()));
			
			System.out.println(bDto);
		}else {
			bDto.setUnnamed(1);
		}
		if(bDao.writeSub(bDto)) {
			ra.addFlashAttribute("msg","게시글 작성에 성공했습니다.");
			return true;
		}
		return false;
	}
	
}

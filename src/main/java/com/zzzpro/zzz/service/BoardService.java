package com.zzzpro.zzz.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zzzpro.zzz.dao.BoardDao;
import com.zzzpro.zzz.dao.MemberDao;
import com.zzzpro.zzz.dto.BoardDto;
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
				bDto.setB_writer("익명");
			}
			model.addAttribute("bDto", bDto);
			return true;
		}
		return false;
	}

	public boolean writeSub(BoardDto bDto, RedirectAttributes ra) {
		log.info(" ========== > service - writeSub: "+bDto.getB_writer()+" < ==========");
		if(bDto.getUnnamed()==0) {
			MemberDao mDao = null;
			bDto.setB_writerNick(mDao.getNick(bDto.getB_writer()));
		}
		if(bDao.writeSub(bDto)) {
			ra.addFlashAttribute("msg","게시글 작성에 성공했습니다.");
			return true;
		}
		return false;
	}
	
}

package com.zzzpro.zzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zzzpro.zzz.dto.MemberDto;
import com.zzzpro.zzz.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	
	/* 컨트롤러는 진짜 컨트롤만! */
	
	@Autowired
	private MemberService mSer;
	
	@GetMapping("/member/joinfrm")
	public String joinfrm() {
		log.info(" ========== > controller - joinfrm < ==========");
		return "join";
	}
	@PostMapping("/member/join")
	public String join(MemberDto mDto, RedirectAttributes ra) {
		log.info(" ========== > controller - join < ==========");
		boolean result = mSer.join(mDto, ra);
		if(result) {
			return "redirect:/member/loginfrm";
		}
		return "redirect:/member/joinfrm";
	}
	
	@GetMapping("/member/loginfrm")
	public String loginfrm() {
		log.info(" ========== > controller - loginfrm < ==========");
		return "login";
	}
	@PostMapping("/member/login")
	public String login(MemberDto mDto, RedirectAttributes ra, HttpSession session) {
		log.info(" ========== > controller - login < ==========");
		boolean result = mSer.login(mDto, ra, session);
		if(result) {
			return "redirect:/";
		}
		return "redirect:/member/loginfrm";
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		log.info(" ========== > controller - logout < ==========");
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
}

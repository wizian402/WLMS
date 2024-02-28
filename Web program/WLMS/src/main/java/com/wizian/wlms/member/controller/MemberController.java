package com.wizian.wlms.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wizian.wlms.member.model.MemberVO;
import com.wizian.wlms.member.service.IMemberService;

@Controller
public class MemberController {

	@Autowired
	@Qualifier("memberService")
	IMemberService memberService;

	@GetMapping(value = "/member/signIn")
	public String signIn(Model model) {
		model.addAttribute("groupList", memberService.getAllGroupName());
		return "/member/signIn";
	}

	@PostMapping("/member/signIn")
	public String signIn(MemberVO member, Model model) {
		memberService.insertMember(member);
		return "redirect:/";

	}

	@GetMapping(value = "/member/login")
	public String login(Model model) {
		return "/member/login";
	}

	@PostMapping(value = "/member/login")
	public String login(String id, String password, HttpSession session, Model model) {
		MemberVO memberVO = memberService.selectMember(id);
		session.setMaxInactiveInterval(600);
		session.setAttribute("id", id);
		session.setAttribute("memberGroup", memberVO.getMemberGroup());
		return "/member/login";
	}
}

package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.test.entity.Member;
import com.test.mapper.BoardMapper;

@Controller
public class MemberController {
	@Autowired // 생성자를 자동으로 실행
	BoardMapper mapper;

	@GetMapping("/member/memberList")
	public void listMember(Model model) {
		
		model.addAttribute("list", mapper.selectMemberList());
	}
	@GetMapping("/member/memberRegistry")
	public void getMemberRegistry() {}
	
	@PostMapping("/member/memberRegistry")
	public String postMemberRegistry(Member member) {
		mapper.insertMember(member.getUserid(), member.getUsername(), member.getAge());
		return "redirect:/member/memberList";
	}
	@GetMapping("/member/memberUpdate")
	public void updateMemberRegistry() {}
	@PostMapping("/member/memberUpdate")
	public String updateMemberRegistry1(Member member) {
		
		mapper.updateMember(member.getAge(), member.getUsername(), member.getUserid());
	
		return "redirect:/member/memberList";
	}
}
	

package com.test.android;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Member;
import com.test.mapper.BoardMapper;

@RestController
public class MemberAndroidController {

	@Autowired //의존성 주입(DI:Dependency Injection)
	BoardMapper mapper;
	
	@GetMapping("/android/memberList")
	List<Member> getMemberList(){
		
		return mapper.selectMemberList();
	}
	
//	@GetMapping("/android/updateAge/{age}")
//	void getUpdateAge(@PathVariable("age") int age) {
//		String userid = "abcd";
//		mapper.updateMember(age, userid);
//	
//	}
}

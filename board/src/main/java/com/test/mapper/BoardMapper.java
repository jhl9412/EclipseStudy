package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.entity.Member;

@Mapper
public interface BoardMapper {
	@Select("select userid, username, age from tbl_test order by userid")
	public List<Member> selectMemberList();
	@Insert("insert into tbl_test (userid, username, age) values ('${userid}', '${username}', '${age}')")
	public void insertMember(@Param("userid") String userid,
			@Param("username") String username, @Param("age") int age);
	@Update("update tbl_test set age = ${age}, username= '${username}' where userid='${userid}'")
	public void updateMember(@Param("age") int age, @Param("username") String username, @Param("userid") String userid);
}

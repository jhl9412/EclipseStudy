package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.entity.Boiler;

@Mapper
public interface BoilerMapper {
	
	@Select("select id, temp, status from boiler order by temp ASC")
	public List<Boiler> selectBoilerList();
	
	@Insert("insert into boiler(temp, status) values ('${temp}', '${status}')")
	public void insertBoiler(@Param("temp") int temp, 
			@Param("status") String status);
	
	@Update("update boiler set status='${status}' where id='${id}'")
	public void updateBoiler(@Param("status") String status, @Param("id") int id);
	
}

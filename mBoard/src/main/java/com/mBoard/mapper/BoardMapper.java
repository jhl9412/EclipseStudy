package com.mBoard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import com.mBoard.entity.Board;
import com.mBoard.entity.Reply;

@Mapper
public interface BoardMapper {

	//게시물 목록보기
	@Select("select * from tbl_mboard order by seqno desc")
	List<Board> selectList();
	
	//게시물 상세 내용 보기
	@Select("select * from tbl_mboard where seqno=${seqno}")
	Board viewList(@Param("seqno") int seqno);
	
	//게시물 수정
	@Update("update tbl_mboard set mwriter='${mwriter}', mtitle='${mtitle}', mcontent ='${mcontent}', filename ='${filename}', filesize =${filesize} where seqno=${seqno}")
	void updateList(@Param("mwriter") String mwriter, @Param("mtitle") String mtitle, @Param("mcontent") String mcontent, @Param("filename") String filename, @Param("filesize") long filesize, @Param("seqno") int seqno);
	
	//게시물 등록
	@Insert("insert into tbl_mboard (userid, mwriter,mtitle,mcontent,filename,filesize) values ('${userid}','${mwriter}','${mtitle}','${mcontent}','${filename}',${filesize})")
	void insertList(@Param("userid") String userid, @Param("mwriter") String mwriter, @Param("mtitle") String mtitle, @Param("mcontent") String mcontent,  @Param("filename") String filename, @Param("filesize") long filesize);
	
	//게시물 삭제
	@Delete("delete from tbl_mboard where seqno = ${seqno}")
	void deleteList(@Param("seqno") int seqno);
	//파일 삭제
	@Delete("delete filename='${filename}' from tbl_mboard where seqno = ${seqno}")
	void deleteFile(@Param("filename") String filename, @Param("seqno") int seqno);
	//댓글 목록 보기
	@Select("select replyseqno, seqno, replywriter, replycontent from tbl_mreply where seqno=${seqno}")
	List<Reply> selectReplyList(@Param("seqno") int seqno);
	//댓글 등록
	@Insert("insert into tbl_mreply (seqno, replycontent, replywriter) values (${seqno},'${replycontent}','${replywriter}') ")
	void insertReply(@Param("seqno") int seqno, @Param("replycontent") String replycontent, @Param("replywriter") String replywriter);
}

package com.mBoard.entity;

import java.time.LocalDateTime;

public class Reply {

	private int replyseqno;
	private int seqno;
	private String replycontent;
	private String replywriter;
	private LocalDateTime replyregdate;
	public int getReplyseqno() {
		return replyseqno;
	}
	public void setReplyseqno(int replyseqno) {
		this.replyseqno = replyseqno;
	}
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getReplycontent() {
		return replycontent;
	}
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}
	public String getReplywriter() {
		return replywriter;
	}
	public void setReplywriter(String replywriter) {
		this.replywriter = replywriter;
	}
	public LocalDateTime getReplyregdate() {
		return replyregdate;
	}
	public void setReplyregdate(LocalDateTime replyregdate) {
		this.replyregdate = replyregdate;
	}
	
}

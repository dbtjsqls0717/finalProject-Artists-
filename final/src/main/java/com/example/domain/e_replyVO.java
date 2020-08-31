package com.example.domain;

import java.sql.Date;

public class e_replyVO extends UsersVO{

	private int r_no;
	private String replyer;
	private String content;
	private Date date;
	private int e_no;
	private int cnt;
	private String nickname;
	private String u_image;
	

	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getU_image() {
		return u_image;
	}
	public void setU_image(String u_image) {
		this.u_image = u_image;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getE_no() {
		return e_no;
	}
	public void setE_no(int e_no) {
		this.e_no = e_no;
	}
	@Override
	public String toString() {
		return "e_replyVO [r_no=" + r_no + ", replyer=" + replyer + ", content=" + content + ", date=" + date
				+ ", e_no=" + e_no + ", cnt=" + cnt + "]";
	}
}

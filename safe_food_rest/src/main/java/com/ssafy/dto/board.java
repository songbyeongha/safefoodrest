package com.ssafy.dto;

import java.util.Date;

public class board {
	private Integer qno;
	private String title;
	private String content;
	private Date inDate;
	private Integer hit;
	
	public board() {
		super();
	}
	public board(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public Integer getQno() {
		return qno;
	}
	public void setQno(Integer qno) {
		this.qno = qno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public Integer getHit() {
		return hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	
	
}

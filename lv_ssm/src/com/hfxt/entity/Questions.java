package com.hfxt.entity;

import java.util.Date;

public class Questions {

	
	private int id;
	private String title;
	private String etailDesc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEtailDesc() {
		return etailDesc;
	}
	public void setEtailDesc(String etailDesc) {
		this.etailDesc = etailDesc;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	private int answerCount;
	private Date lastModified;
	
}

package com.bewithme.www.domain;

public class Community_LikeVO { //커뮤니티 게시글 좋아요

	private int num;
	private String id; //user연결
	private int com_num; //community연결
	
	//getter,setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCom_num() {
		return com_num;
	}
	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}
	
	//toString
	@Override
	public String toString() {
		return "Community_LikeVO [num=" + num + ", id=" + id + ", com_num=" + com_num + "]";
	}
	
	
	//생성자
	public Community_LikeVO() {}
	
	public Community_LikeVO(String id, int com_num) {
		//insert
		this.id = id;
		this.com_num = com_num;
	}
	
	public Community_LikeVO(int num, String id, int com_num) {
		this.num = num;
		this.id = id;
		this.com_num = com_num;
	}
	
	
	
	
	
}

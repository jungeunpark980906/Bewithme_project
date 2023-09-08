package com.bewithme.www.domain;

public class Com_Comment_LikeVO { //커뮤니티 댓글 좋아요

	private int num;
	private String id;//user연결
	private int com_com_num;//com_comment연결
	
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
	public int getCom_com_num() {
		return com_com_num;
	}
	public void setCom_com_num(int com_com_num) {
		this.com_com_num = com_com_num;
	}
	
	//toString
	@Override
	public String toString() {
		return "Com_Comment_LikeVO [num=" + num + ", id=" + id + ", com_com_num=" + com_com_num + "]";
	}
	
	//생성자
	public Com_Comment_LikeVO() {}
	
	public Com_Comment_LikeVO(int num, String id, int com_com_num) {
		this.num = num;
		this.id = id;
		this.com_com_num = com_com_num;
	}
	
	public Com_Comment_LikeVO(String id, int com_com_num) {
		this.id = id;
		this.com_com_num = com_com_num;
	}
	
	
	
	
}

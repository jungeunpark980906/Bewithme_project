package com.bewithme.www.domain;

public class Com_CommentVO {

	private int com_com_num;
	private String com_com_content;
	private String com_com_reg_date;
	private String com_com_mod_date;
	private String com_com_isMod;
	private int com_num;//community연결
	private String id;//user연결
	private String nickname; 
	private int com_com_like_cnt;
	
	//getter,setter
	public int getCom_com_num() {
		return com_com_num;
	}
	public void setCom_com_num(int com_com_num) {
		this.com_com_num = com_com_num;
	}
	public String getCom_com_content() {
		return com_com_content;
	}
	public void setCom_com_content(String com_com_content) {
		this.com_com_content = com_com_content;
	}
	public String getCom_com_reg_date() {
		return com_com_reg_date;
	}
	public void setCom_com_reg_date(String com_com_reg_date) {
		this.com_com_reg_date = com_com_reg_date;
	}
	public String getCom_com_mod_date() {
		return com_com_mod_date;
	}
	public void setCom_com_mod_date(String com_com_mod_date) {
		this.com_com_mod_date = com_com_mod_date;
	}
	public int getCom_num() {
		return com_num;
	}
	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCom_com_isMod() {
		return com_com_isMod;
	}
	public void setCom_com_isMod(String com_com_isMod) {
		this.com_com_isMod = com_com_isMod;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getCom_com_like_cnt() {
		return com_com_like_cnt;
	}
	public void setCom_com_like_cnt(int com_com_like_cnt) {
		this.com_com_like_cnt = com_com_like_cnt;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Com_CommentVO [com_com_num=" + com_com_num + ", com_com_content=" + com_com_content
				+ ", com_com_reg_date=" + com_com_reg_date + ", com_com_mod_date=" + com_com_mod_date
				+ ", com_com_isMod=" + com_com_isMod + ", com_num=" + com_num + ", id=" + id + ", nickname=" + nickname
				+ ", com_com_like_cnt=" + com_com_like_cnt + "]";
	}
	
	//생성자
	public Com_CommentVO() {}
	
	public Com_CommentVO(int com_com_num, String com_com_content, String com_com_reg_date, String com_com_mod_date,
			String com_com_isMod, int com_num, String id, String nickname, int com_com_like_cnt) {
		this.com_com_num = com_com_num;
		this.com_com_content = com_com_content;
		this.com_com_reg_date = com_com_reg_date;
		this.com_com_mod_date = com_com_mod_date;
		this.com_com_isMod = com_com_isMod;
		this.com_num = com_num;
		this.id = id;
		this.nickname = nickname;
		this.com_com_like_cnt = com_com_like_cnt;
	}
	
	
	
	
	
	
	
	
	
	
	
}

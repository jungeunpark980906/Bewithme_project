package com.bewithme.www.domain;

public class CommunityVO {

	private int com_num;
	private String nickname;
	private String com_title;
	private String com_content;
	private String com_category;
	private String com_reg_date;
	private int com_cnt; //조회수
	private int com_like_cnt; //좋아요수
	private int com_comment_cnt; //댓글 수
	private String id; //user연결
	private String com_mod_date;

	
	//getter,setter
	public int getCom_num() {
		return com_num;
	}
	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}
	public String getCom_title() {
		return com_title;
	}
	public void setCom_title(String com_title) {
		this.com_title = com_title;
	}
	public String getCom_content() {
		return com_content;
	}
	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}
	public int getCom_cnt() {
		return com_cnt;
	}
	public void setCom_cnt(int com_cnt) {
		this.com_cnt = com_cnt;
	}
	public String getCom_category() {
		return com_category;
	}
	public void setCom_category(String com_category) {
		this.com_category = com_category;
	}
	public String getCom_reg_date() {
		return com_reg_date;
	}
	public void setCom_reg_date(String com_reg_date) {
		this.com_reg_date = com_reg_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCom_like_cnt() {
		return com_like_cnt;
	}
	public void setCom_like_cnt(int com_like_cnt) {
		this.com_like_cnt = com_like_cnt;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getCom_comment_cnt() {
		return com_comment_cnt;
	}
	public void setCom_comment_cnt(int com_comment_cnt) {
		this.com_comment_cnt = com_comment_cnt;
	}
	public String getCom_mod_date() {
		return com_mod_date;
	}
	public void setCom_mod_date(String com_mod_date) {
		this.com_mod_date = com_mod_date;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "CommunityVO [com_num=" + com_num + ", nickname=" + nickname + ", com_title=" + com_title
				+ ", com_content=" + com_content + ", com_category=" + com_category + ", com_reg_date=" + com_reg_date
				+ ", com_cnt=" + com_cnt + ", com_like_cnt=" + com_like_cnt + ", com_comment_cnt=" + com_comment_cnt
				+ ", id=" + id + ", com_mod_date=" + com_mod_date + "]";
	}


	
	//생성자
	public CommunityVO() {}
	
	//전체
	public CommunityVO(int com_num, String nickname, String com_title, String com_content, String com_category,
			String com_reg_date, int com_cnt, int com_like_cnt, int com_comment_cnt, String id, String com_mod_date) {
		this.com_num = com_num;
		this.nickname = nickname;
		this.com_title = com_title;
		this.com_content = com_content;
		this.com_category = com_category;
		this.com_reg_date = com_reg_date;
		this.com_cnt = com_cnt;
		this.com_like_cnt = com_like_cnt;
		this.com_comment_cnt = com_comment_cnt;
		this.id = id;
		this.com_mod_date = com_mod_date;
	}
	
	
	//게시판 저장 register
	public CommunityVO(String com_title, String com_content, String com_category, String id, String nickname) {
		this.com_title = com_title;
		this.com_content = com_content;
		this.com_category = com_category;
		this.id = id;
		this.nickname = nickname;
	}
	
	//게시판 좋아요 update
	public CommunityVO(int com_num, int com_like_cnt) {
		this.com_num = com_num;
		this.com_like_cnt = com_like_cnt;
	}
	

	
	
	
	
	
	
}
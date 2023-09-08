package com.bewithme.www.domain;

public class Com_FileVO { //커뮤니티 게시글 파일

	private String com_file_uuid;
	private String com_file_save_dir;
	private String com_file_name;
	private int com_file_type;
	private long com_file_size;
	private String com_file_reg_date;
	private int com_num; //community연결
	
	//getter,setter
	public String getCom_file_uuid() {
		return com_file_uuid;
	}
	public void setCom_file_uuid(String com_file_uuid) {
		this.com_file_uuid = com_file_uuid;
	}
	public String getCom_file_save_dir() {
		return com_file_save_dir;
	}
	public void setCom_file_save_dir(String com_file_save_dir) {
		this.com_file_save_dir = com_file_save_dir;
	}
	public String getCom_file_name() {
		return com_file_name;
	}
	public void setCom_file_name(String com_file_name) {
		this.com_file_name = com_file_name;
	}
	public int getCom_file_type() {
		return com_file_type;
	}
	public void setCom_file_type(int com_file_type) {
		this.com_file_type = com_file_type;
	}
	public long getCom_file_size() {
		return com_file_size;
	}
	public void setCom_file_size(long com_file_size) {
		this.com_file_size = com_file_size;
	}
	public String getCom_file_reg_date() {
		return com_file_reg_date;
	}
	public void setCom_file_reg_date(String com_file_reg_date) {
		this.com_file_reg_date = com_file_reg_date;
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
		return "Com_FileVO [com_file_uuid=" + com_file_uuid + ", com_file_save_dir=" + com_file_save_dir
				+ ", com_file_name=" + com_file_name + ", com_file_type=" + com_file_type + ", com_file_size="
				+ com_file_size + ", com_file_reg_date=" + com_file_reg_date + ", com_num=" + com_num + "]";
	}
	
	//생성자
	public Com_FileVO() {}
	
	public Com_FileVO(String com_file_uuid, String com_file_save_dir, String com_file_name, int com_file_type,
			int com_file_size, String com_file_reg_date, int com_num) {
		this.com_file_uuid = com_file_uuid;
		this.com_file_save_dir = com_file_save_dir;
		this.com_file_name = com_file_name;
		this.com_file_type = com_file_type;
		this.com_file_size = com_file_size;
		this.com_file_reg_date = com_file_reg_date;
		this.com_num = com_num;
	}
	

	
	
	
}

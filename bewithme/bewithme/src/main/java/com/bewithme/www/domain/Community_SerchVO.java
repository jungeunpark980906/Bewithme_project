package com.bewithme.www.domain;

public class Community_SerchVO {

	private String keyword;
	private String type;

	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	//타입이 두개이상인 경우 생성자 (여러가지의 타입을 같이 검색에 사용하기 위해서 배열 사용)
	public String[] getTypeToArray() {
		return this.type == null? new String[] {} : this.type.split("");
		//null이면 빈 배열을 생성하고 (넘어온 값이 없다는 것을 리턴), 
		// 아니면 split("")로 잘라서 배열로 가져가 사용
	}
}

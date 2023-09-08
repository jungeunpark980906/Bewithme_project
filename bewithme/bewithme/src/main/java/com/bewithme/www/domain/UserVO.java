package com.bewithme.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserVO {
	private String id;
	private String pw;
	private String nickname;
	private String reg_date;
	private int admin;
}

package com.bewithme.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChatVO {
	private int chat_num;
	private String from_id;
	private String to_id;
	private String chat_content;
	private String chat_time;
}

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
public class CalendarVO {
	private int cal_num;
	private String id;
	private String start_date;
	private String end_date;
	private String cal_content;
	private String url;
}

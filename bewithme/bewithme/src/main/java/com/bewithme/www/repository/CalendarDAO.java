package com.bewithme.www.repository;

import java.util.List;

import com.bewithme.www.domain.CalendarVO;

public interface CalendarDAO {

	int insertSchedule(CalendarVO cal);

	List<CalendarVO> getList();

	CalendarVO getSchedule(int cal_num);

	int updateSchedule(CalendarVO cal);

	int deleteSchedule(int cal_num);

}

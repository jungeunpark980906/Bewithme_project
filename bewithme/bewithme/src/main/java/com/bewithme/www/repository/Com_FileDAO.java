package com.bewithme.www.repository;

import java.util.List;

import com.bewithme.www.domain.Com_FileVO;

public interface Com_FileDAO {

	int insertFile(Com_FileVO fvo);

	List<Com_FileVO> getFileList(int com_num);

	List<Com_FileVO> getFileAllList();

	Com_FileVO getFvo(String uuid);

	int deleteFile(String uuid);

}

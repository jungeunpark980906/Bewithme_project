package com.bewithme.www.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bewithme.www.domain.BookmarkVO;
import com.bewithme.www.domain.CourseVO;
import com.bewithme.www.repository.BookmarkDAO;
import com.bewithme.www.repository.CourseDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
	
	@Inject
	private CourseDAO cdao;
	@Inject
	private BookmarkDAO bdao;

	@Override
	public int insertCourse(CourseVO cvo) {
		log.info("inserCourse Service진입~!!");
		return cdao.insertCourse(cvo);
	}

	@Override
	public List<CourseVO> getList(int sub_num) {
		log.info("getList Service진입~!!");
		return cdao.getList(sub_num);
	}

	@Override
	public CourseVO getTitleContent(int cou_num) {
		log.info("getTitleContentt Service진입~!!");
		return cdao.getTitleContent(cou_num);
	}

	@Override
	public int remove(int cou_num) {
		log.info("getTitleContentt Service진입~!!");
		return cdao.remove(cou_num);
	}

	@Override
	public int cou_cnt(int cou_num) {
		log.info("조회수 Service진입~!!");
		return cdao.cou_cnt(cou_num);
	}

	@Override
	public int modifyCourse(CourseVO cvo) {
		log.info("courseModify Service진입~!!");
		return cdao.modifyCourse(cvo);
	}
	
	
	@Override
	public int updateBookmark(BookmarkVO bookvo) {
		log.info("북마크 Service진입~!!");
		
		//bookmark id와 cou_num이 일치하는지 확인
		int isBook = bdao.isBook(bookvo);
		if(isBook > 0) {
			return bdao.delete(bookvo);
		}else {
			return bdao.insert(bookvo);
		}
	}

	@Override
	public List<Integer> bookList(String id) {
		log.info("북마크list Service진입~!!");
		return bdao.bookList(id);
	}

	@Override
	public int booklist(BookmarkVO bookvo) {
		log.info(">>> booklist  Service진입~!!");
		return bdao.booklist(bookvo);
	}

	@Override
	public String SummerNoteImageFile(MultipartFile file) {
		// TODO Auto-generated method stub
		String url="";
		String fileRoot = "C:\\summernoteImg\\";
		String originalFileName = file.getOriginalFilename();
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		String saveFileName = UUID.randomUUID()+extension;
			
		File targetFile = new File(fileRoot+saveFileName);
		
		try {
			InputStream fileStream = file.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);
			url="/summernoteImg/"+saveFileName;
		} catch(IOException e) {
			FileUtils.deleteQuietly(targetFile);
			e.printStackTrace();
		}	
		return url;
	}










	
}

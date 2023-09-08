package com.bewithme.www.Handler;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bewithme.www.domain.Com_FileVO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

@Slf4j
@AllArgsConstructor
@Component 
public class CommunityFileHandler {

	private static final Logger log = LoggerFactory.getLogger(CommunityFileHandler.class);
	private final String UP_DIR = "C:\\summernoteImg";
	
	public List<Com_FileVO> uploadFiles(MultipartFile[] files){
		
		//---------------- 1. 가져온 파일들을 저장할 폴더를 생성 ----------------------
		
		//일자별로 파일을 정리할 예정 ( date )
		LocalDate date = LocalDate.now(); 
		log.info(">>> date : " + date);
		
		String today = date.toString(); //date객체를 string으로 변환 ( 2023-06-14 형태 ) 
		
		// 년도안의 월안의 일 폴더로 계층적 폴더를 만들예정 2023\06\14(window) , 2023/06/14(ios/linux)
		today = today.replace("-", File.separator);//today를 '-'기준으로 자르기
		//today로 폴더 구성 (경로 구성)
		File folders = new File(UP_DIR, today); 
		//폴더가 기존에 있다면 생성x, 없다면 생성
		if(!folders.exists()) {//폴더가 없는 경우
			folders.mkdirs(); //폴더 생성 명령어 (실제 폴더 생성)
			
		}
		//경로 설정
		List<Com_FileVO> fList = new ArrayList<Com_FileVO>();
		for(MultipartFile file : files) {
			
			// --------- fvo에 저장할 정보 생성 (set) ----------
			Com_FileVO fvo = new Com_FileVO();
			fvo.setCom_file_save_dir(today); //파일 경로 넣기
			fvo.setCom_file_size(file.getSize()); //파일 사이즈 설정
			
			//경로가 포함되어 있을 수도 있는 파일 명
			String originalFileName = file.getOriginalFilename();
			log.info("originalFileName :" + originalFileName);
			//실제 파일 명
			String onlyFileName = originalFileName.substring(
					originalFileName.lastIndexOf(File.separator)+1);
			log.info("onlyFileName : " + onlyFileName);
			//파일의 이름 설정
			fvo.setCom_file_name(onlyFileName);
			
			//UUID(java에서 기본 제공) 생성 + 설정
			UUID uuid = UUID.randomUUID();
			fvo.setCom_file_uuid(uuid.toString());
			
			// --------- 디스크에 저장할 객체 생성 (저장) ----------
			//실제 저장할 파일이름
			String fileName = uuid.toString()+"_"+onlyFileName; 
			//폴더와 이름을 담아 생성
			File storeFile = new File(folders, fileName);
			
			try {
				//원본 객체를 저장할 위한 형태의 객체로 복사 
				file.transferTo(storeFile);
				//파일의 타입 결정
				if(isImgFile(storeFile)) { //이미지인 경우 
					//파일 타입을 1로 변경 (default값으로 0설정되어있음)
					fvo.setCom_file_type(1);
					/*
					 * //썸네일 설정 //썸네일 파일의 경로 File thumbNail = new File(folders,
					 * uuid.toString()+"_th_"+onlyFileName); //썸네일 생성
					 * Thumbnails.of(storeFile).size(75, 75).toFile(thumbNail);
					 */
				}
			} catch (Exception e) {
				log.info(">>> 파일 생성 오류 발생");
				e.printStackTrace();
			}
			//fList에 생성한 fvo넣고
			fList.add(fvo);
		}
		//fList리턴
		return fList;
		
		
		
	}
	//tika를 이용한 파일 형식 체크 메서드 (여기서만 사용할 예정이라 private)
	//이미지파일이 맞으면 true아니면 false 리턴
	private boolean isImgFile(File storeFile) throws IOException {
		//해당하는 이미지의 타입을 빼기 (image/jpg, image/png 모양의 string형태)
		String mimeType = new Tika().detect(storeFile); 
		log.info(mimeType);
		return mimeType.startsWith("image")? true : false;
	}
	
	
	public int deleteFile(Com_FileVO fvo) {
		
		boolean isOk = false;
		
		//경로
		File folders = new File(UP_DIR, fvo.getCom_file_save_dir());
		//삭제할 파일명
		String fullFileName = fvo.getCom_file_uuid()+"_"+fvo.getCom_file_name();
		//삭제
		File removeFile = new File(folders+File.separator+fullFileName);
		isOk = (removeFile.delete())? true: false;
		
		return isOk ? 1 : 0;
	}
	
	
}

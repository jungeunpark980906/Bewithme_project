package com.bewithme.www.Handler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bewithme.www.domain.Com_FileVO;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Slf4j
@AllArgsConstructor
@Component
public class FileHandler {
	private final String UP_DIR = "C:\\summernoteImg";
	
	public List<Com_FileVO> uploadFiles(MultipartFile[] files){
		LocalDate date = LocalDate.now();
		log.info(">>> date : "+date);
		String today = date.toString(); //2023-06-14 date 객체를 String 변환
		// today => 폴더 구조로 변경 2023\06\14(win) 2023/01/01(linux)
		today = today.replace("-", File.separator);
		
		//today 폴더 구성
		File folders = new File(UP_DIR, today);
		
		//폴더가 기존에 있다면 생성X 없다면 생성O
		if(!folders.exists()) {
			folders.mkdirs(); //폴더 생성 명령
		}
		
		//경로 설정
		List<Com_FileVO> fList = new ArrayList<Com_FileVO>();
		for(MultipartFile file : files) {
			Com_FileVO fvo = new Com_FileVO();
			fvo.setCom_file_save_dir(today); //파일 경로 설정
			fvo.setCom_file_size(file.getSize()); // 파일 사이즈 설정 return Long
			
			//경로가 포함되어있을 수도 있는 파일명
			String originalFileName = file.getOriginalFilename();
			log.info(">>> originalFileName : "+originalFileName); //파일명

			String onlyFileName = originalFileName.substring(
					originalFileName.lastIndexOf(File.separator)+1); //실제 파일명만 추출
			log.info(">>> onlyFileName : "+onlyFileName); //파일명
			fvo.setCom_file_name(onlyFileName); //파일 이름 설정
			
			//UUID 생성
			UUID uuid = UUID.randomUUID();
			fvo.setCom_file_uuid(uuid.toString()); //uuid설정
			// <---- 여기까지 fvo에 저장할 정보 생성  -> set
			
			//디스크에 파일 저장할 객체 생성 -> 저장
			String fullfileName = uuid.toString()+"_"+onlyFileName;
			File storeFile = new File(folders, fullfileName);
			
			//생성
			try {
				file.transferTo(storeFile); //원본 객체를 저장을 위한 형태의 객체로 복사
				// 파일 타입 결정 -> 이미지 파일 이라면 썸네일 생성 
				if(isImageFile(storeFile)) {
					fvo.setCom_file_type(0);
					File thumbNail = new File(folders, uuid.toString()+"_th_"+onlyFileName);
					Thumbnails.of(storeFile).size(150, 150).toFile(thumbNail);
				}
			} catch (Exception e) {
				log.info(">>> file 생성 오류~!!");
				e.printStackTrace();
			}
			fList.add(fvo);
		}
		
		return fList;
		
	}
	//tika를 사용하여 파일 형식 체크 -> 이미지 파일이 맞는지 체크
	private boolean isImageFile(File storeFile) throws IOException {
		String mimeType = new Tika().detect(storeFile); // image/jpg, image/png
		return mimeType.startsWith("image")? true : false;
	}
	
	public int deleteFile(Com_FileVO fvo) {
		boolean isDel=false;
		File fileDir = new File(UP_DIR, fvo.getCom_file_save_dir());
		if(!fileDir.exists()) {
			return 0;
		}
		String fullfileName = fvo.getCom_file_uuid()+"_"+fvo.getCom_file_name();
		String fullThumFileName = fvo.getCom_file_uuid()+"_th_"+fvo.getCom_file_name();

		File removeFile = new File(fileDir+File.separator+fullfileName);
		File removeThumFile = new File(fileDir+File.separator+fullThumFileName);
		
		if(removeFile.exists() || removeThumFile.exists()) {
			isDel=removeFile.delete(); //리턴형태는 boolean
			log.info(">>> removeFile > "+(isDel ? "OK" : "Fail"));
			if(isDel) {
				isDel=removeThumFile.delete();
				log.info(">>> removeThumFile > "+(isDel ? "OK" : "Fail"));
			}
		}
		log.info(">>> FileHandler remove OK!");
		return isDel? 1: 0;
	}
	
}

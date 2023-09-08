package com.bewithme.www.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class CommunityDTO{

	private CommunityVO cvo;
	private List<Com_FileVO> flist;
	
	public CommunityDTO() {}
	
	
	public CommunityDTO(CommunityVO cvo, List<Com_FileVO> flist) {
		this.cvo = cvo;
		this.flist = flist;
	}


	public CommunityVO getBvo() {
		return cvo;
	}
	public void setBvo(CommunityVO cvo) {
		this.cvo = cvo;
	}
	public List<Com_FileVO> getflist() {
		return flist;
	}
	public void setflist(List<Com_FileVO> flist) {
		this.flist = flist;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [cvo=" + cvo + ", flist=" + flist + "]";
	}
	
}

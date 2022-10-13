
package com.yedam.mohobby.service.moim;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface MoimService {
	//소모임 등록
	public void moimInsert(MoimVO moimVO);
	
	//소모임 멤버 모집 조회(6개씩)
	public List<MoimVO> moimrecruitMember();
	
	//소모임 인기목록 조회
	public List<MoimVO> moimPopularSelect();
	
	//소모임명 조회
	public List<MoimVO> moimNameSelect();
	
	//소모임 카테고리 조회
	public List<MoimVO> moimCatgSelect();
	
	//소모임 종합 검색
	public List<MoimVO> moimAllSearch(String moimName, String moimCatg);
	
	//소모임 게시판 전체 리스트 조회
	public List<MoimBoardVO> moimAllBoard(int moimId, int boardType);
	
	//소모임 모임이름 중복체크
	public int memberIdCheck(String moimName);
}


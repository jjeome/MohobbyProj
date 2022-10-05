package com.yedam.mohobby.web.sns;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.mohobby.service.communal.JjimVO;
import com.yedam.mohobby.service.sns.SnsPostVO;
import com.yedam.mohobby.service.sns.SnsService;

@RestController
@CrossOrigin
public class SnsController {
    
    @Autowired
    SnsService service;
    
   //전체피드
    @GetMapping("/main")
    public List<SnsPostVO> allList() {
        return service.allList();
    }
    //인기강사피드
    @GetMapping("/hotLecturerList")
    public List<SnsPostVO> hotLecturerList() {
        return service.hotLecturerList();
    }
  //최신피드
    @GetMapping("/newList")
    public List<SnsPostVO> newList() {
        return service.newList();
    }
  //인기피드
    @GetMapping("/hotList")
    public List<SnsPostVO> hotList() {
        return service.hotList();
    }
  //전체 피드
    @GetMapping("/searchHashtag")
    public List<SnsPostVO> searchHashtag() {
        return service.searchHashtag(null);
    }
    
    
  //좋아요클릭 - insert
    @PostMapping("/feedDetail")
    public JjimVO clickLike(@RequestBody JjimVO jjimVO) {
        service.addLike(jjimVO);
        return jjimVO;
    }
  //좋아요누적 - update
    @PostMapping("/feedDetail")
    public SnsPostVO addLikes(@RequestBody SnsPostVO snsPostVO) {
        service.sumLikes(snsPostVO);
        return snsPostVO;
    }
  //좋아요상태 변경 - update
    @PostMapping("/feedDetail")
    public JjimVO updateLike(@RequestBody JjimVO jjimVO) {
        service.updateLike(jjimVO);
        return jjimVO;
    }
    
  //피드 상세
    @GetMapping("/feedDetail")
    public void feedDetail(int postId, String memberId, Model model) {
        System.out.println("피드상세보기");
        model.addAttribute("feed", service.feedDetail(postId));
        
        JjimVO like = new JjimVO();
        
        like.setTargetId(postId);
        like.setMemberId(memberId);
        
//        model.addAttribute("like", service.isLike(postId, memberId));
//        model.addAttribute("getLike", service.getLike(postId));
       
        
        
    }
}
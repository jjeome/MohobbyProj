
package com.yedam.mohobby.web.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.mohobby.service.classes.ClassInfoRequestVO;
import com.yedam.mohobby.service.classes.ClassListRequestVO;
import com.yedam.mohobby.service.classes.ClassService;
import com.yedam.mohobby.service.classes.ClassesVO;
import com.yedam.mohobby.service.communal.JjimVO;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class ClassController {
	@Autowired
	ClassService classService;
	
	//html 파일 생성
	@PostMapping("/saveClassInfo")
	public void saveClassInfo(@RequestBody ClassInfoRequestVO req) {
		classService.saveClassInfo(req);
	}
	
	//html 파일 경로 가져오기
	@GetMapping("/readClassInfo")
	public String readClassInfo(@RequestParam int classId) {
	    return classService.readClassInfo(classId);
	}
	
	
	
	//QR코드 생성
	@GetMapping(
	        value = "/AttdQR",
	        produces = MediaType.IMAGE_PNG_VALUE
	        )
	public @ResponseBody String createCodeImg(
	        @RequestParam String link
	){
	    
	    return classService.createCodeImg(link);
	       
	    
	}
	
	
	//강의 전체 조회
	/**
	 * 
	 * @param catg
	 * @param memberId
	 * @return
	 */
	@GetMapping("/class/{catg}")
	public @ResponseBody List<ClassesVO> listAll(
	        @PathVariable String catg,
	        @RequestParam String memberId
	) {
	    ClassListRequestVO req = new ClassListRequestVO();
	    req.setCatg(catg);
	    req.setMemberId(memberId);
	    return classService.listAll(req);
	}
	
	
	//강의 단건 조회
	/**
	 * 
	 * @param classId
	 * @return
	 */
	@GetMapping("/class/detail/{classId}")
	public @ResponseBody ClassesVO listOne(@PathVariable int classId,  @RequestParam String memberId) {
	    ClassListRequestVO req = new ClassListRequestVO();
	    req.setClassId(classId);
	    req.setMemberId(memberId);
	    return classService.listOne(req);
	}
	
	
	//찜 등록
	@PostMapping("/class/jjim")
	public void addJjim(@RequestBody JjimVO jjim) {
	    classService.addJjim(jjim);
	}
	
	//찜 등록 취소
	@DeleteMapping("/class/jjim")
	public void delJjim(@RequestBody JjimVO jjim) {
	    classService.deleteJjim(jjim);
	}
	

}


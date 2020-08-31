package com.example.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.domain.e_replyVO;
import com.example.mapper.ExhibitionMapper;
import com.example.mapper.e_replyMapper;



@Controller
public class e_replyController {
	
	@Autowired
	e_replyMapper mapper;
	@Autowired
	ExhibitionMapper eMapper;
	
	@RequestMapping("/reply/list")
	@ResponseBody
	public HashMap<String,Object> list(int e_no,Criteria cri) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		cri.setPerPageNum(5);
		
		PageMaker pm=new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(eMapper.replyCount(e_no));
		map.put("pm",pm);
		map.put("list", mapper.list(cri,e_no));
		map.put("count", eMapper.replyCount(e_no));
		return map;
	}
	
	@RequestMapping(value="/like/update", method = RequestMethod.POST)
	@ResponseBody
	public void LikeUpdate(Model model,@RequestParam(value ="id") String id,@RequestParam(value ="r_no") int r_no) {
		int chk=eMapper.likeTableChk(id, r_no);
		
		if(chk==0) {
			eMapper.likeinsert(id, r_no);
		}else {
			eMapper.likedelete(id, r_no);

		}
	}

	@RequestMapping("/reply/insert")
	@ResponseBody
	public void insert(e_replyVO vo) {
		mapper.insert(vo);
	}
	@RequestMapping("/reply/delete")
	@ResponseBody
	public void delete(int r_no) {
		int cnt=mapper.likeCnt(r_no);
		if(cnt==0) {
			mapper.delete(r_no);
		}else {
			mapper.likeDelete(r_no);
			mapper.delete(r_no);
		}
	}
	@RequestMapping("/reply/reply")
	public void reply() { 

	}
}

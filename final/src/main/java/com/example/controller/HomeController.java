package com.example.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mapper.BoardMapper;
import com.example.mapper.ExhibitionMapper;
import com.example.mapper.FeedMapper;
import com.example.mapper.ProductMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	ExhibitionMapper emapper;
	
	@Autowired
	BoardMapper bMapper;
	
	@Autowired
	ProductMapper pMapper;
	
	@Autowired
	FeedMapper fMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int targetCnt = fMapper.getFollowing(id);
		
		model.addAttribute("elist",emapper.list());
		model.addAttribute("list",bMapper.list());
		model.addAttribute("listA",bMapper.listA());
		model.addAttribute("listB",bMapper.listB());
		model.addAttribute("plist",pMapper.artgoods());
		model.addAttribute("cnt",targetCnt);
		model.addAttribute("flist",fMapper.feedList(id, targetCnt));
		return "home";
	}

	
	@RequestMapping("/exRead")
	public void exRead() {
		
	}
	
	@RequestMapping("/exList")
	public void exList() {
		
	}
	
	@RequestMapping("/menu")
	public void menu() {
		
	}
	
	@RequestMapping("/footer")
	public void footer() {
		
	}
	
	@RequestMapping("/home")
	public void home(Model model) {	
		model.addAttribute("list",bMapper.list());
		model.addAttribute("listA",bMapper.listA());
		model.addAttribute("listB",bMapper.listB());
	}
	
	   /*�씠誘몄��뙆�씪 釉뚮씪�슦���뿉 異쒕젰*/ 
    @Resource(name="uploadPath") /*�뙆�씪 �뾽濡쒕뱶瑜� �쐞�빐 �븘�슂*/
     private String path;

 // �씠誘몄��뙆�씪 釉뚮씪�슦���뿉 異쒕젰
    @RequestMapping("/display")
    @ResponseBody
    public ResponseEntity<byte[]> display(String fileName) throws Exception {
       ResponseEntity<byte[]> result = null;
       // display fileName�씠 �엳�뒗 寃쎌슦
       if (!fileName.equals("")) {
          File file = new File(path + File.separator + fileName);
          HttpHeaders header = new HttpHeaders();
          header.add("Content-Type", Files.probeContentType(file.toPath()));
          result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
       }
       return result;
    }

}

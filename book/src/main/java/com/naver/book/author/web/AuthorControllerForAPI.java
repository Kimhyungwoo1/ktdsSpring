package com.naver.book.author.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naver.book.author.service.AuthorService;
import com.naver.book.author.vo.AuthorListVO;
import com.naver.book.author.vo.AuthorSearchVO;
import com.naver.book.author.vo.AuthorVO;

@Controller
public class AuthorControllerForAPI {
	
	private AuthorService authorService;
	
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@GetMapping("/api/v1/author/list")
	@ResponseBody
	public AuthorListVO getAllAuthors(AuthorSearchVO authorSearchVO) {
		
		AuthorListVO authorListVO = authorService.getAllAuthor(authorSearchVO);
		
		return authorListVO;
		
	}
	
	@PostMapping("/api/v1/author/write")
	@ResponseBody
	public Map<String, Boolean> writeAuthor(AuthorVO authorVO) {
		
		boolean result = authorService.addNewAuthor(authorVO);
		
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
		resultMap.put("result", result);
		
		return resultMap;
		
	}
	
	@GetMapping("/api/v1/author/detail/{id}")
	@ResponseBody
	public AuthorVO selectOneAuthor(@PathVariable String id) {
		
		AuthorVO oneAuth = authorService.getSelectOneAuthor(id);
		
		return oneAuth;
	}

}

package com.naver.book.publisher.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naver.book.publisher.service.PublisherService;
import com.naver.book.publisher.vo.PublisherListVO;
import com.naver.book.publisher.vo.PublisherSearchVO;
import com.naver.book.publisher.vo.PublisherVO;

@Controller
public class PublisherControllerForAPI {
	
	private PublisherService publisherService;
	
	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
	@GetMapping("/api/v1/pub/list")
	@ResponseBody
	public PublisherListVO getAllPublishers(PublisherSearchVO publisherSearchVO) {
		
		PublisherListVO publisherListVO = publisherService.getAllPublisher(publisherSearchVO);
		
		return publisherListVO;
	}
	
	@PostMapping("/api/v1/pub/write")
	@ResponseBody
	public Map<String, Boolean> writePublisher(PublisherVO publisherVO) {
		
		boolean result = publisherService.addNewPublisher(publisherVO);
		
		Map<String, Boolean> resultMap = new HashMap<String, Boolean> ();
		resultMap.put("result", result);
		
		return resultMap;
	}
	

}

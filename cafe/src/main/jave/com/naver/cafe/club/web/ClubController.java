package com.naver.cafe.club.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.naver.cafe.club.service.ClubService;
import com.naver.cafe.club.vo.ClubListVO;
import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;
import com.naver.cafe.common.DownloadUtil;
import com.naver.cafe.common.web.ListPageExplorer;
import com.naver.cafe.menu.vo.MenuVO;

@Controller
public class ClubController {

	private Logger logger = LoggerFactory.getLogger(ClubController.class);
	
	private ClubService clubService;
	
	public void setClubService(ClubService clubService) {
		this.clubService = clubService;
	}
	
	@RequestMapping("/club/{menuId}")
	public ModelAndView viewClubListPage(@PathVariable String menuId, ClubSearchVO clubSearchVO, HttpSession session) {
		
		if ( clubSearchVO.getPageNo() == null || clubSearchVO.getPageNo().length() == 0) {
			
			ClubSearchVO clubSearchVOInSession = (ClubSearchVO) session.getAttribute("_SEARCH_");
			
			if ( clubSearchVOInSession != null ) {
				clubSearchVO = clubSearchVOInSession;
			}
		}
		
		clubSearchVO.setMenuId(menuId);
		ClubListVO clubListVO = clubService.getAllClub(clubSearchVO);
		
		session.setAttribute("_SEARCH_", clubSearchVO); 		//가장 마지막에 들어온 페이지가 세션에 
															//저장이 되어서 뒤로를 눌러도 페이지가 초기화가 안된다.
		
		ModelAndView view = new ModelAndView();
		view.addObject("menu", clubListVO.getMenuList());
		view.addObject("clubList", clubListVO.getClubList());
		view.addObject("totalCount", clubListVO.getPager().getTotalArticleCount());
		view.addObject("currentMenu", clubListVO.getCurrentMenu());
		view.addObject("menuId", menuId);
		
		ListPageExplorer pageExplorer = new ListPageExplorer(clubListVO.getPager());
		String pager = pageExplorer.getPagingList("pageNo", " @ ", " 이전 ", " 다음 ", "searchForm");
		view.addObject("pager", pager);
		
		view.setViewName("club/list");
		return view;
	}
	
	@RequestMapping("/club/{menuId}/init")
	public String viewClubListInitPage(@PathVariable String menuId, HttpSession session) {
		session.removeAttribute("_SEARCH_");
		return "redirect:/club/" + menuId;
	}
	//read에서 조회수를 증가시키는 일만 한다.
	@RequestMapping("/club/read/{menuId}/{id}")
	public String viewReadDetailPage(@PathVariable String menuId, @PathVariable String id) {
		
		ClubVO clubVO = new ClubVO();
		clubVO.setMenuId(menuId);
		clubVO.setArticleId(id);
		
		boolean isSuccess = clubService.addReadCount(clubVO);
		
		return "redirect:/club/detail/" + menuId + "/" + id;
	}
	
	@RequestMapping("/club/detail/{menuId}/{id}")
	public ModelAndView viewDetailPage(@PathVariable String menuId, @PathVariable String id) {
		ModelAndView view = new ModelAndView();
		view.addObject("menuId", menuId);
		
		view.setViewName("club/detail");
		
		ClubVO clubVO = new ClubVO();
		clubVO.setArticleId(id);
		clubVO.setMenuId(menuId);
		
		Map<String, Object> club = clubService.getOneClub(clubVO);
		ClubVO clubVOs = (ClubVO) club.get("club");
		List<MenuVO> allMenu = (List<MenuVO>) club.get("menu");
		List<MenuVO> currentMenu = (List<MenuVO>) club.get("currentMenu");
		
		view.addObject("clubList", clubVOs);
		view.addObject("menu", allMenu);
		view.addObject("currentMenu", currentMenu);
		
		
		return view;
	}
	@RequestMapping(value="/club/write/{menuId}", method=RequestMethod.GET)
	public ModelAndView viewWriteArticlePage(@PathVariable String menuId) {
		ModelAndView view = new ModelAndView();
		view.setViewName("club/write");
		view.addObject("menuId", menuId);
		return view;
		
	}
	@RequestMapping(value="/club/write/{menuId}", method=RequestMethod.POST)
	public String doWriteArticleAction(@PathVariable String menuId, ClubVO clubVO) {
		
		clubVO.setMenuId(menuId);
		clubVO.setMemberId("user");
		
		boolean isSuccess = clubService.addNewClub(clubVO);
		
		return "redirect:/club/" + menuId;
		
	}
	
	@RequestMapping(value="/club/upload", method=RequestMethod.POST)
	public void doUploadFile(MultipartHttpServletRequest request, HttpServletResponse response) {
		
		MultipartFile file = request.getFile("file");
		
		if( file != null && !file.isEmpty() ) {
			File uploadPath = new File("/Users/kimhyungwoo/Desktop/uploadFiles/" + 
								file.getOriginalFilename().replaceAll(" ", "_"));
			
			try {
				file.transferTo(uploadPath);
			} catch (IllegalStateException e) {
				throw new RuntimeException(e.getMessage(), e);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			
			try {
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("parent.document.getElementById('uploadFiles').innerHTML += ");
				out.write("'<p>http://localhost:8080/cafe/club/download/" +
							file.getOriginalFilename()
								.replaceAll(" ", "_")
								.replaceAll("[.]", "_dot_") + "</p>';");
				out.write("</script>");
				out.flush();
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			
		}
		
	}
	@RequestMapping("/club/download/{fileName}")
	public void downloadAttachedFile(@PathVariable String fileName
			, HttpServletRequest request, HttpServletResponse response){
		
		DownloadUtil download = DownloadUtil.getInstance("/Users/kimhyungwoo/Desktop/uploadFiles/");
		fileName = fileName.replaceAll("_dot_", ".");
		try {
			download.download(request, response, fileName, fileName);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}
}

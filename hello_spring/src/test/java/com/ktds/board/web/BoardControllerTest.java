package com.ktds.board.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.ktds.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/userContext.xml","classpath:/applicationContext.xml","classpath:/boardContext.xml", "classpath:/rootContext.xml"})
@WebAppConfiguration
public class BoardControllerTest {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before		//Test 하기전에 수행해주는 소스
	public void setUp() {
		mockMvc = webAppContextSetup(ctx).build();
	}
	
	@Test
	public void viewBoardListPageTest() throws Exception {
		
		mockMvc.perform(get("/board"))
					.andExpect(status().isOk())
					.andExpect(model().attributeExists("allArticles"))
					.andExpect(view().name("/board/list"));
	}
	
	@Test
	public void viewWritePageTest() throws Exception {
		
		mockMvc.perform(get("/board/write"))
				.andExpect(status().isOk())
				.andExpect(view().name("/board/write"));
		
	}
	
	@Test
	public void viewDetailTest() throws Exception {
		 mockMvc.perform(get("/board/detail/100"))
		 		.andExpect(status().isOk())
		 		.andExpect(model().attributeExists("board"))
		 		.andExpect(view().name("/board/detail"));
	}
	
	@Test
	public void viewDetailErrorTest() throws Exception {
		 mockMvc.perform(get("/board/detail/99999"))
		 		.andExpect(status().is(null));
	}
	
	@Test
	public void doWriteActionTest() throws Exception {
		
		File f = new File("/Users/kimhyungwoo/Downloads/테이블정의.docx");
		FileInputStream fis = new FileInputStream(f);
		MockMultipartFile file = new MockMultipartFile("file", f.getName(), "multipart/form-data", fis);
		
		MockMultipartHttpServletRequestBuilder builder =fileUpload("/board/write");
		builder.param("subject", "제목입니다. 제목입니다. 제목입니다.");
		builder.param("content", "내용입니다. 내용입니다. 내용입니다.");
		builder.param("writer", "작성자 입니다.");
		builder.file(file);
		
		UserVO user = new UserVO();
		user.setUserId("user");
		user.setUserName("user");
		user.setUserPassword("123123");
		
		builder.sessionAttr("_USER_", user);
		
		mockMvc.perform( builder )
				.andExpect(model().hasNoErrors())
				.andExpect(status().is(302))
				.andExpect(redirectedUrl("/board"));
		
	}
	
}

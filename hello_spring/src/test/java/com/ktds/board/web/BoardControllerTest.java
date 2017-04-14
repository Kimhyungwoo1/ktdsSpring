package com.ktds.board.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/applicationContext.xml","classpath:/boardContext.xml", "classpath:/rootContext.xml"})
@WebAppConfiguration
public class BoardControllerTest {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Test
	public void viewBoardListPageTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/board"))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.model().attributeExists("allArticles"))
					.andExpect(MockMvcResultMatchers.view().name("board/list"));
	}
	
}

package com.ktds.board.biz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ktds.board.biz.BoardBiz;
import com.ktds.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/rootContext.xml", "classpath:/boardContext.xml"})
public class BoardBizImplTest {

	@Autowired
	private BoardBiz boardBizImpl;
	
	/*@Test
	public void getAllArticle() {
		List<BoardVO> boardList = boardBizImpl.getAllArticle();
		assertNull(boardList);
	}*/
	
	@Test
	public void selectOneArticle() {
		BoardVO boardSelect = boardBizImpl.selectOneArticle(91);
		assertEquals(91, boardSelect.getBoardId());
	}
	
	@Test
	public void insertArticle() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId(999);
		boardVO.setSubject("테스트 입니다.");
		boardVO.setContent("테스트 입니다.");
		boardVO.setWriter("테스트 입니다.");
		boardVO.setWriteDate("테스트 입니다.");
		
		boolean boardInsert = boardBizImpl.insertArticle(boardVO);
		assertTrue(boardInsert);
		
	}
	
	@Test
	public void deleteArticle() {
		
		boolean boardDelete = boardBizImpl.deleteArticle(999);
		assertTrue(boardDelete);
	}
	
}

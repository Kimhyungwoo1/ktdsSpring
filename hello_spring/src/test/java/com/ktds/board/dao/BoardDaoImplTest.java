package com.ktds.board.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ktds.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/rootContext.xml", "classpath:/boardContext.xml"})
public class BoardDaoImplTest {

	@Autowired
	private BoardDao boardDaoImpl;
	
	/*@Test
	public void getAllArticles(){
		List<BoardVO> boardList = boardDaoImpl.getAllArticles();
		assertNull(boardList);
	}*/
	
	@Test
	public void getOneArticle(){
		BoardVO boardGetOne = boardDaoImpl.getOneArticle(91);
		assertEquals(91, boardGetOne.getBoardId());
	}
	
	@Test
	public void insertArticle(){
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId(999);
		boardVO.setSubject("테스트 입니다.");
		boardVO.setContent("테스트 입니다.");
		boardVO.setWriter("테스트 입니다.");
		boardVO.setWriteDate("테스트 입니다.");
		
		int boardInsert = boardDaoImpl.insertArticle(boardVO);
		assertEquals(1, boardInsert);
	}
	
	@Test
	public void deleteArticle(){
		int boardDelete = boardDaoImpl.deleteArticle(91);
		assertEquals(1, boardDelete);
	}
	
}

package com.ktds.board.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ktds.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/boardContext.xml", "classpath:/rootContext.xml"})
//@TransactionConfiguration
//@Transactional
public class BoardServiceImplTest {

	@Autowired	//변수의 이름이 같은 변수를 bean컨테이너에서 가져와라 라는 의미이다.
	private BoardService boardServiceImpl;
	
	@Test
	public void getAllArticle() {
		List<BoardVO> boardList = boardServiceImpl.getAllArticle();
		assertTrue(boardList.size() > 0);
	}
	
	/*@Test(expected=NumberFormatException.class) //이 에러가 나야 정상이야. 라고 말해주는 소스
	public void getAllArticleThrowNumberFormatException() {
		List<BoardVO> boardList = boardServiceImpl.getAllArticle();
	}*/
	
	@Test
	public void selectOneArticle() {
		BoardVO boardSelect = boardServiceImpl.selectOneArticle(91);
		assertEquals(91, boardSelect.getBoardId());
	}
	@Test
	public void insertArticle(){
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId(999);
		boardVO.setContent("테스트 입니다.");
		boardVO.setSubject("테스트 입니다.");
		boardVO.setWriter("테스트 입니다.");
		boardVO.setWriteDate("테스트 입니다.");
		
		boolean boardInsert = boardServiceImpl.insertArticle(boardVO);
		assertTrue(boardInsert);
	}
	@Test
	public void deleteArticle() {
		boolean boardDelete = boardServiceImpl.deleteArticle(87);
		assertTrue(boardDelete);
	}
}

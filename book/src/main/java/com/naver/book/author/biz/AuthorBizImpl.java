package com.naver.book.author.biz;

import java.util.ArrayList;
import java.util.List;

import com.naver.book.author.dao.AuthorDao;
import com.naver.book.author.vo.AuthorListVO;
import com.naver.book.author.vo.AuthorSearchVO;
import com.naver.book.author.vo.AuthorVO;
import com.naver.book.common.web.Pager;

public class AuthorBizImpl implements AuthorBiz {

	private AuthorDao authorDao;
	
	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	@Override
	public boolean addNewAuthor(AuthorVO authorVO) {
		return authorDao.insertNewAuthor(authorVO) > 0;
	}

	@Override
	public AuthorListVO getAllAuthor(AuthorSearchVO authorSearchVO) {
		
		AuthorListVO authorListVO = new AuthorListVO();
		Pager pager = authorListVO.getPager();
		pager.setPageNumber(authorSearchVO.getPageNo());
		
		int authorCount = authorDao.selectAllAuthorCount(authorSearchVO);
		pager.setTotalArticleCount(authorCount);
		
		authorSearchVO.setEndArticleNumber(pager.getEndArticleNumber());
		authorSearchVO.setStartArticleNumber(pager.getStartArticleNumber());
		
		if ( authorCount > 0 ) {
			List<AuthorVO> authorList = authorDao.selectAllAuthor(authorSearchVO);
			authorListVO.setAuthorList(authorList);
		}
		else {
			authorListVO.setAuthorList(new ArrayList<AuthorVO>());
		}
		
		return authorListVO;
	}

	@Override
	public AuthorVO getSelectOneAuthor(String id) {
		return authorDao.selectOneAuthor(id);
	}
	
}

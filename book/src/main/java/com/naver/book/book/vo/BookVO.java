package com.naver.book.book.vo;

import java.util.List;

import com.naver.book.author.vo.AuthorVO;
import com.naver.book.publisher.vo.PublisherVO;

public class BookVO {

	private String bookId;
	private String bookName;
	private String bookSubName;
	private String releaseDate;
	private String isbn;
	private int price;
	private String bookIntro;
	private String index;
	private String publisherId;
	
	//파라미터 받아오기
	private List<String> authorId;

	//private AuthorVO authorVO;
	private PublisherVO publisherVO;
	
	/**
	 * write page에서 사용되는 list
	 * List Page에서 사용되는 List(도서의 저자)
	 */
	private List<AuthorVO> authorList;
	
	/**
	 * write page에서 사용되는 list
	 */
	private List<PublisherVO> publisherList;
	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookSubName() {
		return bookSubName;
	}

	public void setBookSubName(String bookSubName) {
		this.bookSubName = bookSubName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBookIntro() {
		return bookIntro;
	}

	public void setBookIntro(String bookIntro) {
		this.bookIntro = bookIntro;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public PublisherVO getPublisherVO() {
		return publisherVO;
	}

	public void setPublisherVO(PublisherVO publisherVO) {
		this.publisherVO = publisherVO;
	}

	public List<AuthorVO> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<AuthorVO> authorList) {
		this.authorList = authorList;
	}

	public List<PublisherVO> getPublisherList() {
		return publisherList;
	}

	public void setPublisherList(List<PublisherVO> publisherList) {
		this.publisherList = publisherList;
	}
	
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	
	public String getPublisherId() {
		return publisherId;
	}

	public List<String> getAuthorId() {
		return authorId;
	}

	public void setAuthorId(List<String> authorId) {
		this.authorId = authorId;
	}
	
	

}

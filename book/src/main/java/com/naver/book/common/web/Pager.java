package com.naver.book.common.web;

public abstract class Pager {
	
	public static final boolean ORACLE = true;
	public static final boolean OTHER = false;
	
	private int totalArticleCount;

	protected int printArticle;
	int printPage;

	protected int startArticleNumber;
	protected int endArticleNumber;

	int totalPage;
	int totalGroup;

	int nowGroupNumber;

	int groupStartPage;

	int nextGroupPageNumber;
	int prevGroupPageNumber;

	protected int pageNo;
	
	/**
	 * Paging κ°μ²΄λ₯? ?»?΄?¨?€.
	 * ? ??΄μ§??Ή λ³΄μ¬μ§?? κ²μκΈ? ? 10κ°?
	 * ? ??΄μ§??Ή λ³΄μ¬μ§?? ??΄μ§? ? 10κ°?
	 * λ‘? κΈ°λ³Έ ?€? ?¨.
	 */
	public Pager() {
		this.printArticle = 10;
		this.printPage = 10;
	}
	
	public Pager(int printArticle, int printPage) {
		this.printArticle = printArticle;
		this.printPage = printPage;
	}
	
	public void setPageNumber(int pageNumber) {
		setPageNumber(pageNumber + "");
	}
	
	/**
	 * ?μ²?? ??΄μ§?? λ²νΈλ₯? ?»?΄?¨?€.
	 * 1 ??΄μ§?? κ²½μ° 0?΄ ?? ₯??€.
	 * ?λ¬΄κ²? ?? ₯?μ§? ???€λ©? 0?Όλ‘? κΈ°λ³Έ ?€? ??€.
	 * @param pageNumber
	 */
	public void setPageNumber(String pageNumber) {
		this.pageNo = 0;
		try {
			this.pageNo = Integer.parseInt(pageNumber);
		} catch (NumberFormatException nfe) {
			this.pageNo = 0;
		}

		computeArticleNumbers();
		
		this.nowGroupNumber = this.pageNo / this.printPage;
		this.groupStartPage = (this.nowGroupNumber * this.printPage) + 1;

		this.nextGroupPageNumber = this.groupStartPage + this.printPage - 1;
		this.prevGroupPageNumber = this.groupStartPage - this.printPage - 1;
	}
	
	protected abstract void computeArticleNumbers();
	
	/**
	 * μ‘°ν?? €? μ‘°κ±΄(Query)? μ΄? κ²μλ¬? ?λ₯? ? ???€.
	 * @param count
	 */
	public void setTotalArticleCount(int count) {
		this.totalArticleCount = count;

		this.totalPage = (int) Math.ceil((double) this.totalArticleCount
				/ this.printArticle);
		this.totalGroup = (int) Math.ceil((double) this.totalPage
				/ this.printPage);
	}
	
	/**
	 * μ‘°ν?? €? μ‘°κ±΄(Query)? μ΄? κ²μλ¬? ?λ₯? κ°?? Έ?¨?€.
	 * @return
	 */
	public int getTotalArticleCount() {
		return this.totalArticleCount;
	}

	/**
	 * Query?? ?¬?©?  ?? ?? λ²νΈ 
	 * Oracle? κ²½μ° rownum? ?? λ²νΈ
	 * @return
	 */
	public int getStartArticleNumber() {
		return this.startArticleNumber;
	}
	
	/**
	 * Query?? ?¬?©?  ?? ?? λ²νΈλ₯? ? ???€.
	 * @param startArticleNumber
	 */
	public void setStartArticleNumber(int startArticleNumber) {
		this.startArticleNumber = startArticleNumber;
	}
	
	/**
	 * Query?? ?¬?©?  ?? ? λ²νΈλ₯? ? ???€.
	 * @param endArticleNumber
	 */
	public abstract void setEndArticleNumber(int endArticleNumber);

	/**
	 * Query?? ?¬?©?  ?? λ§μ?λ§? λ²νΈ
	 * Oracle? κ²½μ° rownum? λ§μ?λ§? λ²νΈ
	 * @return
	 */
	public abstract int getEndArticleNumber();
	
}

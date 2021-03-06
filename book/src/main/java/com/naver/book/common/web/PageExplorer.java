package com.naver.book.common.web;

public interface PageExplorer {

	/**
	 * JSP?? Paging κ²°κ³Όλ₯? λ³΄μ¬μ€??€.
	 * getPagingList? &lt;form> ?κ·? ?? ??±??΄?Ό ??€.
	 * @param link Page λ²νΈλ₯? ? ?¬?  Parameter Name
	 * @param pageFormat Page λ²νΈλ₯? λ³΄μ¬μ€? ?¨?΄ @(at)κ°? ??΄μ§? λ²νΈλ‘? μΉν??€. [@]λ‘? ??±?  κ²½μ° [1] [2] [3] μ²λΌ λ³΄μ¬μ§λ€.
	 * @param prev ?΄?  ??΄μ§? κ·Έλ£Ή?Όλ‘? κ°?? λ²νΌ? ?΄λ¦μ ??±??€.
	 * @param next ?€? ??΄μ§? κ·Έλ£Ή?Όλ‘? κ°?? λ²νΌ? ?΄λ¦μ ??±??€.
	 * @param formId ?λ²μκ²? ? ?¬?  Form ? ??΄?λ₯? ??±??€.
	 * @return
	 */
	public String getPagingList(String link, String pageFormat, String prev, String next, String formId);
	
}

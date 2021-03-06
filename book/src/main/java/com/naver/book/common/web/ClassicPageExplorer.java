package com.naver.book.common.web;

public class ClassicPageExplorer implements PageExplorer {

	private Pager pager;
	
	public ClassicPageExplorer(Pager pager) {
		this.pager = pager;
	}
	
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
	public String getPagingList(String link, String pageFormat, String prev, String next, String formId) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("<script>");
		buffer.append("function movePage(pageNo) {");
		buffer.append("$(\"#"+link+"\").val(pageNo);");
		buffer.append("$(\"#"+formId+"\").attr('action', '');");
		buffer.append("$(\"#"+formId+"\").attr('method', 'post');");
		buffer.append("$(\"#"+formId+"\").submit();");
		buffer.append("}");
		buffer.append("</script>");
		
		buffer.append("<input type=\"hidden\" id=\""+link+"\" name=\""+link+"\" />");
		
		if (pager.nowGroupNumber > 0) {
			buffer.append("<a href=\"javascript:movePage('"+pager.prevGroupPageNumber+"')\">" + prev + "</a>");
		}

		int nextPrintPage = pager.groupStartPage + pager.printPage;
		if (nextPrintPage > pager.totalPage) {
			nextPrintPage = pager.totalPage + 1;
		}

		String pageNumber = "";

		for (int i = pager.groupStartPage; i < nextPrintPage; i++) {
			pageNumber = pageFormat.replaceAll("@", i + "");
			if ((i - 1) == pager.pageNo) {
				pageNumber = "<b>" + pageNumber + "</b>";
			}
			buffer.append("<a href=\"javascript:movePage('"+(i - 1)+"')\">" + pageNumber + "</a>");
		}

		if (pager.nowGroupNumber < (pager.totalGroup - 1)) {
			buffer.append("<a href=\"javascript:movePage('"+pager.nextGroupPageNumber+"')\">" + next + "</a>");
		}

		return buffer.toString();
	}
	
}

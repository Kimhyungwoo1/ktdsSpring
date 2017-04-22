package com.naver.cafe.common.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.naver.cafe.common.Auth;
import com.naver.cafe.menu.biz.MenuBiz;
import com.naver.cafe.menu.vo.MenuSearchVO;
import com.naver.cafe.menu.vo.MenuVO;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	private Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	private MenuBiz menuBiz;
	
	public void setMenuBiz(MenuBiz menuBiz) {
		this.menuBiz = menuBiz;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info(request.getRequestURI());
		logger.info(request.getRequestURL().toString());
		
		
		
		HandlerMethod controller = null;
		if (handler instanceof HandlerMethod) {
			controller = (HandlerMethod) handler;
			
			Auth auth = controller.getMethodAnnotation(Auth.class);
			
			if ( auth != null ) {
				String authValue = auth.value();
				//String[] authValue = auth.value();		//권한을 2개 이상 부여하고 싶을때
				String myAuth = "USR";
				
				if ( myAuth.equals("ADM")) {
					return true;
				}
				if ( myAuth.equals(authValue)) {
					return true;
				}
				else {
					throw new RuntimeException("접근 권한이 없습니다.");
				}
			}
			
		}
		
		/*RequestMapping mapping = controller.getMethodAnnotation(RequestMapping.class);
		logger.info(mapping.value()[0]);			//DB 에서비교하기위해 만들었음*/
		
		MenuSearchVO menuSearchVO = new MenuSearchVO();
		//menuSearchVO.setAuth("USR");
		
		List<MenuVO> menuList = menuBiz.getAllMenu(menuSearchVO);
		for (MenuVO menuVO : menuList) {
			
			if ( request.getRequestURI().equals("/cafe" + menuVO.getMenuUrl())) {
				
				if( "USR".equals(menuVO.getAuth()) ) {
					return true;
				}
				else {
					//response.sendRedirect("/cafe");
					//return false;
					throw new RuntimeException("페이지에 접근할 권한이 없습니다.");
					
				}
			}
			
		}
		
		return true;		//컨트롤러 접근전에 수행하는것 true-> 컨트롤러를 수행시켜라, 
	}
	
}

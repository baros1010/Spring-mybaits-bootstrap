package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import bean.UserBean;
import util.CommonConstant;

@Controller
public abstract class BaseController {
	public abstract ModelAndView list();

	// ②将用户对象保存到Session中
	protected void setSessionUser(HttpServletRequest request, UserBean user) {
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
		
	}
	
	protected UserBean getSessionUser(HttpServletRequest request){
		return (UserBean) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
	}
}

package listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import bean.UserBean;
import util.CommonConstant;

public class MyListener implements HttpSessionListener{

	private static List<UserBean> onlineUserList;

	public void sessionCreated(HttpSessionEvent se,UserBean username) {
		
		se.getSession().setMaxInactiveInterval(10*60);

		 // 取得登录的用户名
		se.getSession().setAttribute(CommonConstant.USER_CONTEXT, username);
        onlineUserList.add(username);
        System.out.println(onlineUserList);
		se.getSession().getServletContext().setAttribute("onlineUserList", onlineUserList);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO 自動生成されたメソッド・スタブ
		  HttpSession session = se.getSession();
	        ServletContext application = session.getServletContext();

	        // 取得登录的用户名
	        UserBean username = (UserBean) session.getAttribute(CommonConstant.USER_CONTEXT);

	        // 从在线列表中删除用户名
	        List onlineUserList = (List) application.getAttribute("onlineUserList");
	        onlineUserList.remove(username);

	        System.out.println(username + "超时退出。");
		
	}

	public void sessionCreated(HttpSessionEvent se) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}

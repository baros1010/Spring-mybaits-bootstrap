package filter;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import bean.TokenBean;
import common.Authorization;
import tokenManage.TokenManager;
/**
 * 拦截器 判断权限
 * @author firas
 *
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private TokenManager manager;
	private final static String AUTHORIZATION = "Authorization";

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 如果不是映射到方法直接通过
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		String authorization = request.getHeader(AUTHORIZATION);
		TokenBean token = manager.getToken(authorization);
		if (manager.checkToken(token)) {
			request.setAttribute("userId", token.getUserId());
			return true;

		}
		if(method.getAnnotation(Authorization.class) != null){
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;	
		}
		return true;

	}
}

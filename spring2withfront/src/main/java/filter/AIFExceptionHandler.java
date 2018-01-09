package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import exception.UsersException;


/**
 * Servlet Filter implementation class AIFExceptionHandler
 */
public class AIFExceptionHandler implements Filter {
	private static Logger logger = Logger.getLogger(AIFExceptionHandler.class);
	/**
	 * Default constructor.
	 */
	public AIFExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		try {
			chain.doFilter(request, response);
		} catch (Throwable ex) {
			Throwable th = ex;
			while (true) {
				if (th.getCause() instanceof UsersException) {
					break;
				} else if (th.getCause() instanceof Exception) {
					break;
				}
			}
			if (th instanceof Exception) {
				UsersException uex = (UsersException) th.getCause();
				int statusCode = uex.getErrorStatus();
				HttpServletResponse hsr = (HttpServletResponse) response;
				hsr.setStatus(statusCode);
				hsr.setCharacterEncoding("UTF-8");
				logger.error(ex);
				@SuppressWarnings("unchecked")
				Map<String, String> resObj = (HashMap<String, String>) uex.getResObj();
				String resJson = createErrorJson(resObj.get("errorCode"), resObj.get("errorMessage"));
				hsr.getWriter().write(resJson);
			}else{
				HttpServletResponse hsr = (HttpServletResponse) response;
				hsr.setStatus(500);
				hsr.setCharacterEncoding("UTF-8");
				String resJson = createErrorJson("err","系统出错");
				
				hsr.getWriter().write(resJson);
			}

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	private String createErrorJson(String errorCode, String errorMessage) {
		StringBuilder sb = new StringBuilder();
		sb.append("{").append("\"").append("errorCode").append("\"").append(":").append("\"").append(errorCode)
				.append("\"").append(",").append("\"").append("errorMessage").append("\"").append(":").append("\"")
				.append(errorMessage).append("\"").append("}");
		return sb.toString();
	}

}

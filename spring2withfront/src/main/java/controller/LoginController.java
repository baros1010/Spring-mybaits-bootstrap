package controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bean.UserBean;
import service.LoginService;

@Controller
public class LoginController<HttpServletResponse> extends BaseController {
	@Resource
	public LoginService log;

	@RequestMapping(value = "/logins.html")
	public ModelAndView list() {
		// TODO 自動生成されたメソッド・スタブ
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Map> Login(@RequestBody UserBean userbean,HttpServletRequest req) {
		System.out.println(userbean.getPassword());
		int count = log.isLogin(userbean.getUsername(), userbean.getPassword());
		Map<String,HttpStatus> map=new HashMap<String,HttpStatus>();
		map.put("success", HttpStatus.OK);
		
			setSessionUser(req,userbean);
			return new ResponseEntity<Map>(map,HttpStatus.OK);
			
		
		

	}

}

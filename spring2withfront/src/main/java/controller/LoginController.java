package controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bean.TokenBean;
import bean.UserBean;
import exception.UsersException;
import service.LoginService;
import tokenManage.TokenManager;
import tokenManage.TokenManager2;

@RestController
public class LoginController {
	@Resource
	public LoginService log;
	@Autowired
	TokenManager manager;
	@Autowired
	TokenManager2 manager2;
	@RequestMapping(value = "/logins.html")
	public ModelAndView list() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResponseEntity Login(@RequestBody UserBean userbean) throws UsersException{
		 log.isLogin(userbean.getUsername(), userbean.getPassword());

		//TokenBean token=manager.createToken(userbean.getUsername());
		TokenBean token = manager2.createToken(userbean);
	
		
		return new ResponseEntity(token, HttpStatus.OK);

	}

}

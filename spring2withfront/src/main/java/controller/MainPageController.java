package controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bean.TokenBean;
import tokenManage.TokenManager;

@Controller
public class MainPageController extends BaseController{
	@Autowired
	TokenManager manager;
	@RequestMapping(value = "/main.html")
	public ModelAndView list() {
		ModelAndView view = null ;

			 view = new ModelAndView("main");
			

		return view;
	}
	@RequestMapping(value = "/getPage", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResponseEntity getMainPage(){
		return new ResponseEntity(new HashMap<String,String>(), HttpStatus.OK);
	}

}

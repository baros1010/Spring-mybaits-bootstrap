package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController extends BaseController{
	@RequestMapping(value = "/main.html")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView view = null ;
		
		if(getSessionUser(request)!=null){
		
			 view = new ModelAndView("main");
			
			 
			
		}else{
			 view = new ModelAndView("login");
			
		}
		return view;
	}

	@Override
	public ModelAndView list() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}

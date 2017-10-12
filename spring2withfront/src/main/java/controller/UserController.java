package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController extends BaseController{

	@Override
	@RequestMapping(value = "/table.html")
	public ModelAndView list() {
		// TODO 自動生成されたメソッド・スタブ
		ModelAndView view = new ModelAndView("table");
		return view;
	}

}

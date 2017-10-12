package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import bean.testbean;
@Controller
public class test2 extends BaseController{
	@RequestMapping(value = "/hello2.html")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("test3");
		return view;
	}
	@RequestMapping(value = "/test3", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public testbean helloAjax2() throws JsonProcessingException {
		testbean tb=new testbean();
		tb.setId("2");
		tb.setName("lalala");
		return tb;
	}
}

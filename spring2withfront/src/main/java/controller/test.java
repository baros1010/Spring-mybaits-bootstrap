package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import bean.testbean;

@Controller
public class test extends BaseController{
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("hello", "hello");
		mv.setViewName("test");
		return mv;
	}

	@RequestMapping(value = "/hello.html")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("test2");
		return view;
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public testbean helloAjax() throws JsonProcessingException {
//		String channelId = "hello";
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("channelId", channelId);
//		ObjectMapper mapper = new ObjectMapper();
//		channelId = mapper.writeValueAsString(map);
//
//		return channelId;
		testbean tb=new testbean();
		tb.setId("1");
		tb.setName("hello");
		return tb;
	}
}

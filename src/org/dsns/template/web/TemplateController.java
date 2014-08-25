package org.dsns.template.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dsns.channel.service.interfaces.IChannelSV;
import org.dsns.engine.service.interfaces.ICollectorSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TemplateController {
	@Autowired
	private IChannelSV channelSV;
	@Autowired
	private ICollectorSV collector;
	
	@RequestMapping("/asdlfkjas")
	public ModelAndView hellYeah(HttpServletRequest req) {
		ModelAndView rtn = new ModelAndView();
		rtn.addObject("fuck", "damn");
		
		channelSV.test();
		try {
			collector.collect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Logger.getLogger(TemplateController.class).debug("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		return rtn;
	}
}

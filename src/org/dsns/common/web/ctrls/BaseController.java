package org.dsns.common.web.ctrls;

import java.util.Map;

import org.dsns.common.consts.IViewConst;
import org.springframework.web.servlet.ModelAndView;


public abstract class BaseController {
	
	public ModelAndView list(Map<String, String> qryCondition) {
		return new ModelAndView(IViewConst.LIST);
	}

	
}

package org.dsns.template.service.impls;

import java.util.List;
import java.util.Set;

import org.dsns.common.service.impls.BaseSVImpl;
import org.dsns.template.dao.interfaces.ITemplateDao;
import org.dsns.template.entity.Template;
import org.dsns.template.service.interfaces.ITemplateSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TemplateSV extends BaseSVImpl<Template> implements ITemplateSV {
	
	
	
	
	
	
	
	
	@Override
	public void test() {
		
	}
	
	
	
	
	
	
	
	
	
	@Autowired
	protected void setDao(ITemplateDao channelDao) {
		super.setBaseDao(channelDao);
	}
	protected ITemplateDao getDao() {
		return (ITemplateDao)super.getBaseDao();
	}
}

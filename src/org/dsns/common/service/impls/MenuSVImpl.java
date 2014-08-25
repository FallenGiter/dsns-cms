package org.dsns.common.service.impls;

import org.dsns.common.dao.interfaces.IMenuDao;
import org.dsns.common.entity.Menu;
import org.dsns.common.service.interfaces.IMenuSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuSVImpl extends BaseSVImpl<Menu> implements IMenuSV {
	
	
	
	
	
	@Autowired
	protected void setDao(IMenuDao menuDao) {
		super.setBaseDao(menuDao);
	}
	protected IMenuDao getDao() {
		return (IMenuDao) super.getBaseDao();
	}
}

package org.dsns.common.utils;

import java.util.List;

import org.dsns.common.entity.Menu;
import org.dsns.common.entity.StaticData;
import org.dsns.common.service.interfaces.IMenuSV;
import org.dsns.common.service.interfaces.IStaticDataSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaticDataUtils {
	@Autowired
	private IMenuSV menuSv;
	@Autowired
	private IStaticDataSV staticDataSV;
	
	public List<Menu> loadMenus() {
		return menuSv.findAll();
	}
	
	public StaticData findStaticDataByDataCodeAndDataAlias(String dataCode, String dataAlias) {
		return staticDataSV.findByDataCodeAndDataAlias(dataCode, dataAlias);
	}
}

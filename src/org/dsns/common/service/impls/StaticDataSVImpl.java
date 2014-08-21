package org.dsns.common.service.impls;

import org.dsns.common.dao.interfaces.IStaticDataDao;
import org.dsns.common.entity.StaticData;
import org.dsns.common.service.interfaces.IStaticDataSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StaticDataSVImpl extends BaseSVImpl<StaticData> implements IStaticDataSV {
	
	@Override
	public StaticData findByDataCodeAndDataAlias(String dataCode, String dataAlias) {
		return getDao().findByDataCodeAndDataAlias(dataCode, dataAlias);
	}
	@Autowired
	protected void setDao(IStaticDataDao staticDataDao) {
		super.setBaseDao(staticDataDao);
	}
	protected IStaticDataDao getDao() {
		return (IStaticDataDao) super.getBaseDao();
	}
}

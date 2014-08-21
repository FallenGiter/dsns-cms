package org.dsns.common.dao.interfaces;

import org.dsns.common.entity.StaticData;

public interface IStaticDataDao extends IBaseDao<StaticData> {
	public StaticData findByDataCodeAndDataAlias(String dataCode, String dataAlias);
}

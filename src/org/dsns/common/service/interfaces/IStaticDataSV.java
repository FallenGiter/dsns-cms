package org.dsns.common.service.interfaces;

import org.dsns.common.entity.StaticData;

public interface IStaticDataSV extends IBaseSV<StaticData> {
	 StaticData findByDataCodeAndDataAlias(String dataCode, String dataAlias);
}

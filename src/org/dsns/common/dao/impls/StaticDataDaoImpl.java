package org.dsns.common.dao.impls;

import java.util.ArrayList;
import java.util.List;

import org.dsns.common.dao.interfaces.IStaticDataDao;
import org.dsns.common.entity.StaticData;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class StaticDataDaoImpl extends BaseDaoImpl<StaticData> implements IStaticDataDao {

	@Override
	public StaticData findByDataCodeAndDataAlias(String dataCode, String dataAlias) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if (StringUtils.isEmpty(dataCode)) {
			criterions.add(Restrictions.isNull("dataCode"));
		} else {
			criterions.add(Restrictions.eq("dataCode", dataCode));
		}
		
		if (StringUtils.isEmpty(dataAlias)) {
			criterions.add(Restrictions.isNull("dataAlias"));
		} else {
			criterions.add(Restrictions.eq("dataAlias", dataAlias));
		}
		
		List<StaticData> staticDatas = super.findByCriteria(criterions.toArray(new Criterion[0]));
		
		return (staticDatas != null && staticDatas.size() > 0) ? staticDatas.get(0) : null;
	}
}

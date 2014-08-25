package org.dsns.template.dao.impls;

import org.dsns.common.dao.impls.BaseDaoImpl;
import org.dsns.template.dao.interfaces.ITemplateDao;
import org.dsns.template.entity.Template;
import org.springframework.stereotype.Repository;

@Repository
public class TemplateDao extends BaseDaoImpl<Template> implements ITemplateDao {
	
}

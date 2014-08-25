package org.dsns.engine.service.interfaces;

import java.util.Set;

import org.dsns.template.entity.Template;

public interface IGeneratorSV {
	void gen(Set<Template> templates);
}

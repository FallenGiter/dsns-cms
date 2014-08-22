package org.dsns.engine.service.interfaces;

import java.io.IOException;

import org.dsns.template.entity.Template;

import freemarker.template.TemplateException;


public interface IEngineSV {
	String merge(Object model, Template template) throws TemplateException, IOException, Exception;
}

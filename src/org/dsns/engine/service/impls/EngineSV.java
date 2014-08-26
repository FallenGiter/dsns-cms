package org.dsns.engine.service.impls;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.dsns.common.utils.FileUtils;
import org.dsns.engine.service.interfaces.IEngineSV;
import org.dsns.template.entity.Template;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

@Service
@Scope("singleton")
public class EngineSV implements IEngineSV {
	private final static Logger log = Logger.getLogger(EngineSV.class);
	
	private static Configuration cfg;
	
	static {
		cfg = new Configuration();
		try {
//			cfg.setSettings();
			cfg.setDirectoryForTemplateLoading(new File("E:\\parttime\\dsns-cms\\html\\WEB-INF\\ftl_templates"));
			
			
		} catch (IOException e) {
			log.error("An error ocurr when configging freemarker", e);
		}
	}
	
	
	@Override
	public String merge(Object model, Template template) throws TemplateException, IOException, Exception {
		freemarker.template.Template t = cfg.getTemplate(template.getUri());
		
		StringWriter sw = new StringWriter(256);
		
		FileUtils.ensureFile(new File(template.getGeneratedUri()));
		
		t.process(model, sw);
		
		sw.close();
		
		return sw.toString();
	}

}

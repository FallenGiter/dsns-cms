package org.dsns.template.entity;

import java.io.Serializable;
import java.util.Set;

public class TemplateCategory implements Serializable {
	private Integer id;
	private String name;
	private int ordseq;
	private Set<Template> templates;
	private TemplateCategory parent;
	private Set<TemplateCategory> childs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrdseq() {
		return ordseq;
	}
	public void setOrdseq(int ordseq) {
		this.ordseq = ordseq;
	}
	public Set<Template> getTemplates() {
		return templates;
	}
	public void setTemplates(Set<Template> templates) {
		this.templates = templates;
	}
	public TemplateCategory getParent() {
		return parent;
	}
	public void setParent(TemplateCategory parent) {
		this.parent = parent;
	}
	public Set<TemplateCategory> getChilds() {
		return childs;
	}
	public void setChilds(Set<TemplateCategory> childs) {
		this.childs = childs;
	}
}

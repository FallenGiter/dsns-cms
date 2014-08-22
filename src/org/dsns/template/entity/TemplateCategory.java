package org.dsns.template.entity;

import java.io.Serializable;
import java.util.Set;

import org.dsns.website.entity.Website;

public class TemplateCategory implements Serializable {
	private Integer id;
	private String name;
	private int ordseq;
	private int state;
	private Set<Template> templates;
	private TemplateCategory parent;
	private Set<TemplateCategory> childs;
	
	private Website website;
	
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
	public Website getWebsite() {
		return website;
	}
	public void setWebsite(Website website) {
		this.website = website;
	}
}

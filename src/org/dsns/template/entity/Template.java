package org.dsns.template.entity;

import java.io.Serializable;

import org.dsns.website.entity.Website;

public class Template implements Serializable {
	private Integer id;
	private String name;
	private String uri;
	private String generatedUri;
	private int ordseq;
	private int state;
	
	private TemplateCategory category;
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getGeneratedUri() {
		return generatedUri;
	}

	public void setGeneratedUri(String generatedUri) {
		this.generatedUri = generatedUri;
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

	public TemplateCategory getCategory() {
		return category;
	}

	public void setCategory(TemplateCategory category) {
		this.category = category;
	}

	public Website getWebsite() {
		return website;
	}

	public void setWebsite(Website website) {
		this.website = website;
	}
	
}

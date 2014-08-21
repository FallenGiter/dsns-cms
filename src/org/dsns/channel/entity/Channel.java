package org.dsns.channel.entity;

import java.io.Serializable;
import java.util.Set;

public class Channel implements Serializable {
	private Integer id;
	private String name;
	private String alias;
	private String namespace;
	private String description;
	private int ordseq;
	private Channel parent;
	private Set<Channel> childs;
	
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
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getOrdseq() {
		return ordseq;
	}
	public void setOrdseq(int ordseq) {
		this.ordseq = ordseq;
	}
	public Channel getParent() {
		return parent;
	}
	public void setParent(Channel parent) {
		this.parent = parent;
	}
	public Set<Channel> getChilds() {
		return childs;
	}
	public void setChilds(Set<Channel> childs) {
		this.childs = childs;
	}
}

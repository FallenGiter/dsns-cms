package org.dsns.website.entity;

import java.io.Serializable;
import java.util.Set;

public class Website implements Serializable {
	private Integer id;
	private String name;
	private String domain;
	private String port;
	private String rootUri;
	private String rootTemplateUri;
	
	private Set<HostConfig> hostConfigs;

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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getRootUri() {
		return rootUri;
	}

	public void setRootUri(String rootUri) {
		this.rootUri = rootUri;
	}

	public String getRootTemplateUri() {
		return rootTemplateUri;
	}

	public void setRootTemplateUri(String rootTemplateUri) {
		this.rootTemplateUri = rootTemplateUri;
	}

	public Set<HostConfig> getHostConfigs() {
		return hostConfigs;
	}

	public void setHostConfigs(Set<HostConfig> hostConfigs) {
		this.hostConfigs = hostConfigs;
	}
}

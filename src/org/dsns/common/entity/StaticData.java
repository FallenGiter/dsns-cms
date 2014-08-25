package org.dsns.common.entity;

import java.io.Serializable;

public class StaticData implements Serializable {
	private String dataCode;
	private String dataValue;
	private String dataName;
	private String dataAlias;
	public String getDataCode() {
		return dataCode;
	}
	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public String getDataAlias() {
		return dataAlias;
	}
	public void setDataAlias(String dataAlias) {
		this.dataAlias = dataAlias;
	}
}

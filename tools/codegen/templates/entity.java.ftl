package org.dsns.${e.moduleName}.entity;

import java.io.Serializable;

public class ${e.entityName} implements Serializable {
<#list e.colmuns as col>
	private ${col.javaType} ${col.name};
</#list>

<#list e.colmuns as col1>
	public void ${col1.setter}(${col1.javaType} ${col1.name}) {
		this.${col1.name} = ${col1.name};
	}
	public ${col1.javaType} ${col1.getter}() {
		return this.${col1.name};
	}
</#list>
}

package codegen.bean;

import java.util.HashMap;
import java.util.Map;

public class Column {
	public static final Map<String, String> typeMappings = new HashMap<String, String>();
	
	static {
		typeMappings.put("varchar", "String");
		typeMappings.put("int", "Integer");
	}
	
	private String name;
	private String dbType;
	private int length;
	
	public Column(String name, String dbType, int length) {
		this.name = name;
		this.dbType = dbType;
		this.length = length;
	}

	public String getJavaType() {
		String javaType = Column.typeMappings.get(this.getDbType());
		return ("ordseq".equalsIgnoreCase(this.getName()) || "state".equalsIgnoreCase(this.getName())) ? this.getDbType() : javaType;
	}
	public String getSetter() {
		String name = this.getName();
		return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
	}
	public String getGetter() {
		String name = this.getName();
		return "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
	}
	
	public String getName() {
		String name = this.name;
		if (name != null) {
			String[] fParts = name.split("_");
			int len = fParts.length, tmpLen;
			char[] tmp;
			
			StringBuffer sb = new StringBuffer(8);
			for (int i = 0; i < len; i++) {
				if (i == 0) {
					sb.append(fParts[i]);
				} else {
					tmp = fParts[i].toCharArray();
					tmpLen = tmp.length;
					for (int j = 0; j < tmpLen; j++) {
						if (j ==0) {
							sb.append(Character.toUpperCase(tmp[j]));
						} else {
							sb.append(tmp[j]);
						}
					}
				}
			}
			return sb.toString();
		}
		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}

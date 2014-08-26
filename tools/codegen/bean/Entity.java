package codegen.bean;

import java.util.ArrayList;
import java.util.List;

public class Entity {
	private String tableName;
	private List<Column> colmuns;
	public Entity(String tableName) {
		this.tableName = tableName;
		this.colmuns = new ArrayList<Column>();
	}
	
	public void addColumns(Column column) {
		this.colmuns.add(column);
	}

	public String getModuleName() {
		return this.getTableName().split("_")[1].toLowerCase();
	}

	public String getTableName() {
		return tableName;
	}
	public String getEntityName() {
		String[] tParts = this.getTableName().replace("cms_", "").split("_");
		StringBuffer sb = new StringBuffer(8);
		for (String tp : tParts) {
			sb.append(tp.substring(0, 1).toUpperCase() + tp.substring(1));
		}
		
		return sb.toString();
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<Column> getColmuns() {
		return colmuns;
	}

	public void setColmuns(List<Column> colmuns) {
		this.colmuns = colmuns;
	}
}

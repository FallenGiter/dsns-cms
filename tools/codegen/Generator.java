package codegen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.dsns.common.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import codegen.bean.Column;
import codegen.bean.Entity;
import freemarker.template.Configuration;
import freemarker.template.Template;

@Component
public class Generator {
	@Autowired
	private DataSource ds;
	
	private static Configuration cfg;
		
	static {
		cfg = new Configuration();
		try {
			cfg.setDirectoryForTemplateLoading(new File("E:\\parttime\\dsns-cms\\tools\\codegen\\templates"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("codegen/config/db.xml");
		Generator g = ctx.getBean(Generator.class);
		
		g.genEntities(g.getEntities());
	}
	
	
	
	public void genEntities(List<Entity> entities) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Template t = cfg.getTemplate("/entity.java.ftl");
		
		if (entities != null) {
			for (Entity en : entities) {
				model.clear();
				model.put("e", en);
				File file = new File("E:\\cms\\" + en.getModuleName() + "\\entity\\" + en.getEntityName() + ".java");
				FileUtils.ensureFile(file);
				FileWriter fw = new FileWriter(file);
				t.process(model, fw);
				fw.close();
			}
		}
	}
	
	public List<Entity> getEntities() throws SQLException {
		List<Entity> entities = new ArrayList<Entity>();
		
		Connection conn = null;
		DatabaseMetaData dmd= null;
		try {
			conn = this.ds.getConnection();
			dmd = conn.getMetaData();
			
			ResultSet tables = dmd.getTables(null, null, null, null), columns;
			
			String table;
			Entity entity;
			Column column;
			while (tables.next()) {
				table = tables.getString(3);
				entity = new Entity(table);

				columns = dmd.getColumns(null, null, table, null);
				while (columns.next()) {
					column = new Column(columns.getString(4), columns.getString(6), columns.getInt(7));
					entity.addColumns(column);
				}
				
				entities.add(entity);
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
		return entities;
	}
	
	public Connection getConn() throws SQLException {
		return this.ds.getConnection();
	}
}

/**
 * 
 */
package util;

import model.User;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author yxx03
 *
 */
public class SchemaExportUtil {
	
	/**
	 * This method aims on exporting the user schema.
	 */
	public static void exportUserSchema(){

		AnnotationConfiguration configuration = new AnnotationConfiguration();

		configuration
		    .addAnnotatedClass(User.class)
		    .setProperty(Environment.USER, "HBXTRACK")
		    .setProperty(Environment.PASS, "winter2015")
		    .setProperty(Environment.URL, "jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = vracdev2.health.state.ny.us)(PORT = 1521))(ADDRESS = (PROTOCOL = TCP)(HOST = vracdev1.health.state.ny.us)(PORT = 1521))(LOAD_BALANCE = YES)(CONNECT_DATA = (SERVER = DEDICATED)(SERVICE_NAME = gendev.health.state.ny.us)(FAILOVER_MODE = (TYPE = SELECT)(METHOD = basic)(RETRIES = 180)(DELAY = 5))))")
		    .setProperty(Environment.DIALECT, "org.hibernate.dialect.OracleDialect")
		    .setProperty(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");

		SchemaExport schema = new SchemaExport(configuration);
		schema.setOutputFile("schema.sql");

		schema.create(true, false);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		exportUserSchema();
	}

}

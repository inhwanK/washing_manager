package washing_manager.conn;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class WashingJdbcUtil {
	
	public static Connection getConnection() {
		String propsPath = "washing_db.properties";
		Connection conn = null;
		
		try(InputStream is = ClassLoader.getSystemResourceAsStream(propsPath)){
			Properties prop = new Properties();
			prop.load(is);
			conn = DriverManager.getConnection(prop.getProperty("url"), prop);
		}catch(IOException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}

}

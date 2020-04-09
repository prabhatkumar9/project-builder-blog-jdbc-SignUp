package utility;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class ConnectionManager{
    public static Connection getConnection() throws Exception {
	Properties prop;
	prop = loadPropertiesFile();
	Connection con;
	final String driver = prop.getProperty("driver");
	final String url = prop.getProperty("url");
	final String user = prop.getProperty("username");
	final String password = prop.getProperty("password");
	
	Class.forName(driver);
	con = DriverManager.getConnection(url,user,password);
	if(con != null) {
	    return con;
	}else
	    return null;
    }
    
    public static Properties loadPropertiesFile() throws Exception{
   	Properties prop = new Properties();
   	InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
   	prop.load(in);
   	in.close();
   	return prop;
       }
   }

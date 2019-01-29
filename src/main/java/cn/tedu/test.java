package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class test {
	        
	        
	         private static   BasicDataSource dataSource;
	
	     static {
	    	  Properties pr=new Properties();
	    	  InputStream is =test.class.getClass().getResourceAsStream("jdbc.properties");
	    	  try {
				pr.load(is);
				 String driver=pr.getProperty("driver");
				 String  url=pr.getProperty("url");
				 String  username=pr.getProperty("username");
				 String  password=pr.getProperty("password");
				 String   initSize=pr.getProperty("initSize");
				 String   maxSize=pr.getProperty("maxSize");
				
		    	   dataSource =new BasicDataSource();
		    	    dataSource.setDriverClassName(driver);
		    	    dataSource.setUrl(url);
		    	    dataSource.setUsername(username);
		    	    dataSource.setPassword(password);
		    	    dataSource.setInitialSize(Integer.parseInt(initSize));
		    	    dataSource.setMaxActive(Integer.parseInt(maxSize));
		    	  
			} catch (IOException e) {
			
				e.printStackTrace();
			}
	    	 
	     }
	
      private static Connection conn() throws IOException, SQLException {
    	
    	   
    	  
		return dataSource.getConnection();
    	  
      }
}

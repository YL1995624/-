package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	
	
	  private static  BasicDataSource dataSource;
	
	  static {
		  Properties pe= new Properties();
		  InputStream is= DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		 
		  try {
			  pe.load(is);
			  String driver=pe.getProperty("driver");
			  String url=pe.getProperty("url");
			  String username=pe.getProperty("username");
			  String password=pe.getProperty("password");
			  String initSize=pe.getProperty("initSize");
			  String maxSize=pe.getProperty("maxSize");
		
			//  创建链接池数据对象 
			  dataSource =new BasicDataSource();
			  
			  
			 //设定链接池链接地址
			  dataSource.setDriverClassName(driver);
			  dataSource.setUrl(url);
			  dataSource.setUsername(username);
			  dataSource.setPassword(password);
			  //设定初始链接数量和最大链接数据
			  dataSource.setInitialSize(Integer.parseInt(initSize));
			  dataSource.setMaxActive(Integer.parseInt(maxSize));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		  
		  
		  
	  }  
	
	
      public static Connection conn() throws Exception {
		return dataSource.getConnection();
    	  
    	  
      }
}

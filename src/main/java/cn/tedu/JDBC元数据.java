package cn.tedu;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBC元数据 {

	public static void main(String[] args) {
	   
		 try (Connection conn = DBUtils.conn();) {
			    //获取数据库元数据
			 DatabaseMetaData db=conn.getMetaData();
			 System.out.println("驱动版本"+db.getDriverMajorVersion());
			 System.out.println("用户名"+db.getUserName());
			 System.out.println("驱数据库厂商"+db.getDatabaseProductName());
			 
			 
			 
			 
			Statement stat = conn.createStatement();
			ResultSet rs=stat.executeQuery("select * from emp");
			//得到表相关的元数据
			ResultSetMetaData rsmd=rs.getMetaData();
			//得到表字段数量
			int count=rsmd.getColumnCount();
			for(int i=0;i<count;i++){
				String name=rsmd.getColumnName(i+1);
				String type=rsmd.getColumnTypeName(i+1);
				System.out.println(name+":"+type);
			}
			
			
			String sql = "";
			
			stat.executeUpdate(sql);

		} catch (Exception e) {

			e.printStackTrace();
		}

		
	}

}

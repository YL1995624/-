package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class jdbc批量操作2 {

	  public static void main(String[] args) {
	  
	  try (Connection conn = DBUtils.conn();) {
		
		  String sql="insert into jdbcperson values(null,?,?);";
		  
		  PreparedStatement stat=conn.prepareStatement(sql);
		  
		  for (int i = 1; i <=100; i++) {
			stat.setString(1,"name"+i);
			stat.setInt(2,100+i);
			//添加到批量操作
			stat.addBatch();
			
			//每个20次执行一次交互  避免囤积次数过多导致系统内存不足 崩溃
			  if(i%20==0) {
					stat.executeBatch();  
			
			  }
			  
		}
		  
		  //避免遗漏
		stat.executeBatch();  
		  
		System.out.println("克里斯关门");

	} catch (Exception e) {

		e.printStackTrace();
	}

		  
	  }
}

package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo03 {
  public static void main(String[] args) {
	  Scanner sc= new Scanner(System.in);
	  
		 System.out.println("请输入用户名");
		 String username=sc.nextLine();
		 System.out.println("请输入密码");
		 String password =sc.nextLine();
		 
		try (Connection conn = DBUtils.conn();) {
			Statement stat = conn.createStatement();
			String sql = "select count(*) from jdbcuser where  username='"+username+"' and password='"+password+"'";
			ResultSet rs =stat.executeQuery(sql);
			while(rs.next()) {
				int count=rs.getInt(1);
				if(count>0) {
					System.out.println("登录成功");
				}else {
					System.out.println("登录失败");
				}
				
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		 
		
		
		
		
}
}

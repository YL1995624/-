package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



public class Demo33SQL注入预编译 {
  public static void main(String[] args) {
	  Scanner sc= new Scanner(System.in);
	  
		 System.out.println("请输入用户名");
		 String username=sc.nextLine();
		 System.out.println("请输入密码");
		 String password =sc.nextLine();
		 
		try (Connection conn = DBUtils.conn();) {
			/*Statement stat = conn.createStatement();
			
			
			String sql = "select count(*) from jdbcuser where  username='"+username+"' and password='"+password+"'";
			ResultSet rs =stat.executeQuery(sql);*/
			
			String sql="select count(*) from jdbcuser where username=? and password=?";
			//创建预编译对象   提前把sql逻辑内容固定
		  PreparedStatement stat=conn.prepareStatement(sql);
			
			//把问号替换成具体变量
			stat.setString(1,username);
			stat.setString(2, password);
			ResultSet  rs=stat.executeQuery();
			
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

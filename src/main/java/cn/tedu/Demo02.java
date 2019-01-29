package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Demo02 {
   public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("请输入你的姓名");
	 String name=sc.nextLine();
	 System.out.println("请输入你的年龄");
	 int age =sc.nextInt();
	 
	 
	 
	 //把上面得到的用户名和年龄保存到刚才的表中
	 
	 try (Connection conn = DBUtils.conn();) {
		/*Statement stat = conn.createStatement();
		 * String sql = "insert into jdbcperson values()";
		 * stat.executeUpdate(sql);
		 * */
		 
		String sql = "insert into jdbcperson values(null,?,?)";
		
		PreparedStatement stat=conn.prepareStatement(sql);
		stat.setString(1,name);
		stat.setInt(2,age);
		stat.executeUpdate();
System.out.println(1);
	} catch (Exception e) {

		e.printStackTrace();
	}

}
}

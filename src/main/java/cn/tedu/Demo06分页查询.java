package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Demo06分页查询 {
   public static void main(String[] args) {
	    Scanner sc =new Scanner(System.in);
	    System.out.println("请输入查询的页数");
	    int page =sc.nextInt();
	    if(page<=0) {
	    	page=1;
	    }
	    System.out.println("请输入查询每页的条数");
	    int count =sc.nextInt();
	    
	   try (Connection conn = DBUtils.conn();) {
	
		String sql = "select * from jdbcperson limit ?,?";
		PreparedStatement stat = conn.prepareStatement(sql);
		  stat.setInt(1,(page-1)*count);
		  stat.setInt(2,count);
		ResultSet rs =stat.executeQuery();
		
		while(rs.next()) {
			String as=rs.getString("name");
			String bs=rs.getString("age");
			System.out.println(as+","+bs);
		}
		

	} catch (Exception e) {

		e.printStackTrace();
	}

	    
   }
}

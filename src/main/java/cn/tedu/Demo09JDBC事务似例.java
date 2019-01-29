package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo09JDBC事务似例 {

	public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    System.out.println("请输入球队名称");
    String teamName=sc.next();
    System.out.println("请输入球员名称");
    String playerName= sc.next();
    
    try (Connection conn = DBUtils.conn();) {
	/*	Statement stat = conn.createStatement();*/
    	
    	String sql1 = "insert into team values (null,?)";
    
    	PreparedStatement stat1=conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
    	stat1.setString(1,teamName);
    	stat1.executeUpdate();
    	ResultSet rs =stat1.getGeneratedKeys();
    	while (rs.next()) {
    		//得到球队的id
    		int teamid =rs.getInt(1);
    		   
    		
    		//开始保存球员
    		String sql2="insert into player values (null,?,?)";
    	 	PreparedStatement stat2=conn.prepareStatement(sql2);
    	 	stat2.setString(1,playerName);
    	     stat2.setInt(2,teamid);
    	     stat2.executeUpdate();
		}
    	
		System.out.println("OJBK");
		

	} catch (Exception e) {

		e.printStackTrace();
	}


	}

}

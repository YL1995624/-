package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo09JDBC事务似例099 {

	public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    System.out.println("请输入球队名称");
    String teamName=sc.next();
    System.out.println("请输入球员名称");
    String playerName= sc.next();
    
    try (Connection conn = DBUtils.conn();) {
    	String sql="select id from team where name=?";
    	
    	PreparedStatement ps=conn.prepareStatement(sql);
    	ps.setString(1,teamName);
    	
    	ResultSet rs =ps.executeQuery();
    	int teamid=-1;
    	while(rs.next()) {
    		teamid=rs.getInt("id");
    	}
    	
    	if(teamid==-1) {
    		//判断有没有添加过
    		//保存球队
    		PreparedStatement stat=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    		stat.setString(1,teamName );
        
       stat.executeUpdate();
     rs=stat.getGeneratedKeys();
          while(rs.next()) 
          {
        	   teamid=rs.getInt(1);
          }
        	   
          
       String sql2="insert into palyer values(null,?,?)";
       PreparedStatement stat2 =conn.prepareStatement(sql2);
       stat2.setString(1, playerName);
       stat2.setInt(1, teamid);
          stat2.executeUpdate();
    
    	
        
   
    	
		System.out.println("OJBK");
		
    	}
	} 
    	catch (Exception e) {
		e.printStackTrace();
	}
	
	}
	}

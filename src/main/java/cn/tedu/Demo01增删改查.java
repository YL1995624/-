package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;

public class Demo01增删改查 {
   @Test
   public void insert(){
	   try(Connection conn=DBUtils.conn();) {
	   Statement stat=conn.createStatement();
	   String sql="insert into emp (empno,ename,sal) values(110,'lucy',3000)";
		stat.executeUpdate(sql);
	 
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	   
   }
	
   
   
   
   @Test
   public void delete(){
	   
	   try(	Connection conn=DBUtils.conn();) {
		   Statement stat=conn.createStatement();
		   String sql3="delete from emp where empno=110";
			stat.executeUpdate(sql3);
		   
		} catch (Exception e) {
		
			e.printStackTrace();
		}
   }
   
   
   
   @Test
   public void update(){
	   try(	Connection conn=DBUtils.conn();) {
		   Statement stat=conn.createStatement();
		   String sql2="update emp set ename='lulu' where empno=110";
			stat.executeUpdate(sql2);
		   
		} catch (Exception e) {
		
			e.printStackTrace();
		}
   }
   
   
   
   @Test
   public void select(){
	   
	   try(	Connection conn=DBUtils.conn();) {
		   Statement stat=conn.createStatement();
		   String sql1="select * from emp";
		ResultSet rs =stat.executeQuery(sql1);
			while(rs.next()) {
				String name=rs.getString("ename");
				String sal=rs.getString("sal");
				System.out.println(name+":"+sal);
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
   }
}


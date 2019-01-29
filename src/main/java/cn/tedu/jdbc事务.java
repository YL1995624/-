package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc事务 {

	public static void main(String[] args) {
	    try (Connection conn = DBUtils.conn();) {
	    	conn.setAutoCommit(false);
	    	
			Statement stat = conn.createStatement();
			String sql1 = "update jdbchero set money=money-2000 where id=1;";
			String sql2 = "update jdbchero set money=money+2000 where id=2;";
			stat.executeUpdate(sql1);
			stat.executeUpdate(sql2);
//判断 sql1的钱剩于的钱是否大于等于0  满足这个条件才允许转账
			String sql="select money from jdbchero where id=1";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()) {
				int money=rs.getInt("money");
				if(money>=0) {
					System.out.println("转账成功");
					conn.commit();
				}else {
					System.out.println("转账失败");
					conn.rollback();
				}
				
			}
			
			//把自动提交打开
			conn.setAutoCommit(true);
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}


	}

}

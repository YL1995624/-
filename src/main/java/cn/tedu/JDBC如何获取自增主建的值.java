package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC如何获取自增主建的值 {
      public static void main(String[] args) {
		  try (Connection conn = DBUtils.conn();) {
			Statement stat = conn.createStatement();
			String sql = "insert into jdbcperson values(null,'赵本山',30)";
			stat.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
       ResultSet rs=stat.getGeneratedKeys();
       while(rs.next()) {
    	   //得到查询的唯一值
    	   int id =rs.getInt(1);
    	   System.out.println("自增主建为"+id);
       }
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}

package cn.tedu;

import java.sql.Connection;
import java.sql.Statement;

public class jdbc批量操作 {

	  public static void main(String[] args) {
		  try (Connection conn = DBUtils.conn();) {
			Statement stat = conn.createStatement();
			String sql1 = "insert into jdbcperson values(null,'辟马瘟','500')";
			String sql2 = "insert into jdbcperson values(null,'悟空','400')";
			String sql3 = "insert into jdbcperson values(null,'泼猴','300')";
			stat.addBatch(sql1);
			stat.addBatch(sql2);
			stat.addBatch(sql3);
			stat.executeBatch();
			System.out.println("OJBK");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}

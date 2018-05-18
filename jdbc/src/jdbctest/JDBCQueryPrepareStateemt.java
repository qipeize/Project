package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCQueryPrepareStateemt {
     public static void myQuery() {
    	 Scanner in = new Scanner(System.in);
    	 try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到加载驱动类，加载驱动类失败！");
			e.printStackTrace();
		}
    	 try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			System.out.println("请输入员工编号：");
			int no = in.nextInt();
			System.out.println("请输入员工姓名");
			String name = in.next();
			PreparedStatement ps = con.prepareStatement("select count(1) from emp where empno=? and ename=?");
			ps.setInt(1, no);
			ps.setString(2, name);
			ResultSet query = ps.executeQuery();
			if(query.next()) {
				int count = query.getInt(1);
				if(count>0) {
					System.out.println("登录成功！");
				}else {
					System.out.println("登录失败！");
				}
			}
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}
     }
     public static void main(String[] args) {
    	 myQuery();
	}
}

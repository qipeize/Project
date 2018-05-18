package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest2 {
	public static void main(String[] args)  {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动类，驱动类加载异常");
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott","tiger");
			System.out.println("数据库连接成功！");
			String sql = "delete from emp where empno=? and ename=?";
		    PreparedStatement prepareStatement = con.prepareStatement(sql);
		    prepareStatement.setInt(1, 1111);
		    prepareStatement.setString(2, "sc");
		    int count = prepareStatement.executeUpdate();
		    System.out.println("受影响的行数为："+count);
		Statement statement = con.createStatement();
		ResultSet no = statement.executeQuery("select empno from emp");
		while(no.next()) {
			int empno = no.getInt("empno");
			System.out.println(empno);
		}
		    
		
		
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}
	}
}

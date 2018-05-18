package jdbctest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest1 {
 public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException e) {
		System.out.println("找不到驱动程序类 ，加载驱动失败！");
		e.printStackTrace();
	}
	try {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		System.out.println("数据库连接成功！");
		java.sql.Statement statement = conn.createStatement();
//		String sql = "insert into emp(empno,ename,sal) values(1111,'sc',8000)";
//		statement.executeUpdate(sql);
//		String sql = "delete from emp where empno=1111";
//		statement.executeUpdate(sql);
		ResultSet query = statement.executeQuery("select empno,ename,sal from emp");
		while(query.next()) {
			int empno = query.getInt("empno");
			String ename = query.getString("ename");
			int sal = query.getInt("sal");
			System.out.println(empno+"\t"+ename+"\t"+sal);
		}
	} catch (SQLException e) {
		System.out.println("数据库连接失败！");
		e.printStackTrace();
	}

}
}

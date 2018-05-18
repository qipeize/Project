package jdbctest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureTest {
    public static void callableStatement() {
    	try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动类失败！");
			e.printStackTrace();
		}
    	try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
//			CallableStatement call = con.prepareCall("{call raise_salary(?)}");
//			call.setInt(1, 7788);
			CallableStatement call = con.prepareCall("{call addTwoNum(?,?,?)}");
			call.setInt(1, 10);
			call.setInt(2, 60);
			call.registerOutParameter(3,Types.INTEGER);
			call.execute();
			int result = call.getInt(3);
			System.out.println("相加的结果为："+result);
		} catch (SQLException e) {
			System.out.println("连接数据库失败！");
			e.printStackTrace();
		}
    }
    public static void main(String[] args) {
    	callableStatement();
	}
}

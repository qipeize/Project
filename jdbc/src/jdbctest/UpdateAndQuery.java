package jdbctest;

//import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Scanner;

public class UpdateAndQuery {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USERNAME = "scott";
	private static final String PWD = "tiger";
    public static void update(){
    	Connection connection = null;
    	Statement stmt = null;
    	try {
    	Class.forName("oracle.jdbc.OracleDriver");
    	 connection = DriverManager.getConnection(URL, USERNAME, PWD);
        stmt = connection.createStatement();
//    	String sql = "insert into emp(empno,ename) values(1111,'zs')";
        String sql = "delete from emp where empno = 1111";
        int count = stmt.executeUpdate(sql);
        if(count > 0) {
        	System.out.println("已受影响行："+count);
        }else {
        	System.out.println("更新失败！");
        }
    	}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
    public static void query() {
    	Connection connection = null;
    	Statement stmt = null;
    	try {
    	Class.forName("oracle.jdbc.OracleDriver");
    	 connection = DriverManager.getConnection(URL, USERNAME, PWD);
        stmt = connection.createStatement();
    	String sql = "select empno,ename from emp";
    	ResultSet query = stmt.executeQuery(sql);
    	System.out.println("empno"+"\t\t"+"ename");
        while(query.next()) {
        	int no = query.getInt("empno");
        	String name = query.getString("ename");
        	System.out.println(no+"\t\t"+name);
        }
    	}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
    public static void main(String[] args) {
		query();
//		update();
	}
}

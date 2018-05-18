package javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;


public class LoginControl {
	
	public  void addLoginInfo(LoginInfo login){
		 Connection connection = null;
		 PreparedStatement pstmt = null;
	    final String Driver = "oracle.jdbc.OracleDriver";
    	final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    	final String user = "scott";
    	final String password = "tiger";
    	try {
		Class.forName(Driver);
		 connection = DriverManager.getConnection(url, user, password); 
		 System.out.println("数据库连接成功！");
		 String sql = "insert into login values(?,?)";
		 pstmt = connection.prepareStatement(sql);
		 pstmt.setString(1,login.getName() );
		 pstmt.setString(2,login.getPassword() );
		 int count  = pstmt.executeUpdate();
//		 stmt = connection.createStatement();
//		String sql1 = "insert into login values('"+login.getName()+"','"+login.getPassword()+"')";
//		int count = stmt.executeUpdate(sql1);
		if(count > 0) {
			System.out.println("注册成功！");
		}else {
			System.out.println("注册失败！");
		}
    	}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			try {
			if(pstmt != null)pstmt.close();
			if(connection != null)connection.close();
			}catch (SQLException e3) {
				e3.printStackTrace();
			}catch (Exception e4) {
				e4.printStackTrace();
		} 
	}
	}
}
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		LoginInfo loginInfo = new LoginInfo();
//		loginInfo.setName("zs");
//		loginInfo.setPassword("123456");
//		addLonginInfo(loginInfo);
//	}


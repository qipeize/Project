package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ojdbc {
	   private static final String DRIVER="oracle.jdbc.OracleDriver";
	   private static final String URL=	"jdbc:oracle:thin:@localhost:1521:orcl" ;  
	   private static final String USERNAME="scott";
	   private static final String PASSWORD="tiger";
	   
      
	public static void Update() {
		Connection connection=null;
		PreparedStatement stmt=null;
		
		try {
		Class.forName(DRIVER);
	    connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
//		System.out.println("登陆成功");
		
	    String eud="insert into login values(?,?)";
		stmt=connection.prepareStatement(eud);
		stmt.setInt(1,36);
		stmt.setString(2, "zhangsan");
//		stmt.setInt(3, 56);
//		stmt.setString(4, "s3");
		
		int count=stmt.executeUpdate();
		System.out.println("受影响的行数是："+count);
	   
	    if(count>0)
	    {
	    	System.out.println("操作成功！");
	    }
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
		   try
		   {
			   if(stmt!=null)stmt.close();
			   if(connection!=null)connection.close();
		   
			}catch(SQLException e)
			{
				e.printStackTrace();
			}	
		}
		
}
//	public static void query()
//	{
//		Connection connection=null;
//		PreparedStatement stmt=null;
//		ResultSet rs=null;
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		    connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
//		    Scanner input=new Scanner(System.in);
//		    System.out.println("请输入用户名：");
//		    String name=input.nextLine();
//		    System.out.println("请输入密码：");
//		    String pwd=input.nextLine();
//		    String eud="select count(*) from login where uname=? and upwd==？";
//		    stmt=connection.prepareStatement(eud);
//		    stmt.setString(1, name);
//		    stmt.setString(2, pwd);
//		    rs=stmt.executeQuery();
//		    int count=-1;
//		    if(rs.next())
//		    {
//		    	count=rs.getInt(1);
//		    }
//		    if(count>0)
//		    {
//		    	System.out.println("登陆成功！");
//		    }else
//		    {
//		    	System.out.println("登陆失败！");	
//		    }
//		}catch(ClassNotFoundException e)
//		{
//			e.printStackTrace();
//		}catch(SQLException e)
//		{
//			e.printStackTrace();
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}finally
//		{
//		   try
//		   {
//			   if(rs!=null)rs.close();
//			   if(connection!=null)connection.close();
//		   
//			}catch(SQLException e)
//			{
//				e.printStackTrace();
//			}
//		}
//	}
//		
		
		
		
	public static void main(String[] args)
	{
		Update();
		//query();
	}

}
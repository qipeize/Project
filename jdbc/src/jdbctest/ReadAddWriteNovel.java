package jdbctest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ReadAddWriteNovel {
	static PreparedStatement pstmt = null;
    public static void ReaderNovel() throws ClassNotFoundException, SQLException, IOException {
    	final String Driver = "oracle.jdbc.OracleDriver";
    	final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    	final String user = "scott";
    	final String password = "tiger";
		Class.forName(Driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "insert into novel values(?,?)";
	    pstmt = connection.prepareStatement(sql);
	    pstmt.setInt(1, 1);
	    
	   
	    File file = new File("E:\\douluo.txt");
	    InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
	    pstmt.setCharacterStream(2, reader,(int)file.length());
	    int count = pstmt.executeUpdate();
	    if(count>0) {
	    	System.out.println("小说写入成功！");
	    }else {
	    	System.out.println("小说写入失败！");
	    }
	    reader.close();
	    if(pstmt != null) pstmt.close();
	    if(connection != null) connection.close();
	}
    
    public static void WriteNovel() throws ClassNotFoundException, SQLException, IOException {
    	final String Driver = "oracle.jdbc.OracleDriver";
    	final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    	final String user = "scott";
    	final String password = "tiger";
		Class.forName(Driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		
		String sql = "select * from novel where id=?";
	    pstmt = connection.prepareStatement(sql);
	    pstmt.setInt(1, 1);
	    
	    ResultSet rs= pstmt.executeQuery();
	   
	    while(rs.next()) {
	    	
	    	Reader reader = rs.getCharacterStream("mynovel");
	    	
	    	Writer writer = new FileWriter("src/douluo.txt");
	    	int len = -1;
	    	char[] temp = new char[500];
	    	while((len = reader.read(temp) ) != -1) {
	    		writer.write(temp,0,len);
	    	}
	    	writer.close();
	    	reader.close();
	    	System.out.println("小说读取成功！");
	      
	}  
    }
    
}

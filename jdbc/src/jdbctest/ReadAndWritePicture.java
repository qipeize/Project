package jdbctest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadAndWritePicture {
	static PreparedStatement pstmt = null;
    public static void ReaderPicture() throws ClassNotFoundException, SQLException, IOException {
    	final String Driver = "oracle.jdbc.OracleDriver";
    	final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    	final String user = "scott";
    	final String password = "tiger";
		Class.forName(Driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "insert into picture values(?,?)";
	    pstmt = connection.prepareStatement(sql);
	    pstmt.setInt(1, 1);
	    
	   
	    File file = new File("E:\\fengjing.png");
	    FileInputStream stream = new FileInputStream(file);
	    pstmt.setBinaryStream(2, stream,file.length());;
	    int count = pstmt.executeUpdate();
	    if(count>0) {
	    	System.out.println("图片写入成功！");
	    }else {
	    	System.out.println("图片写入失败！");
	    }
	    stream.close();
	    if(pstmt != null) pstmt.close();
	    if(connection != null) connection.close();
	}
    
    public static void WritePicture() throws ClassNotFoundException, SQLException, IOException {
    	final String Driver = "oracle.jdbc.OracleDriver";
    	final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    	final String user = "scott";
    	final String password = "tiger";
		Class.forName(Driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		
		String sql = "select * from picture where id=?";
	    pstmt = connection.prepareStatement(sql);
	    pstmt.setInt(1, 1);
	    
	    ResultSet rs= pstmt.executeQuery();
	   
	    while(rs.next()) {
	    	
	    	InputStream inputStream = rs.getBinaryStream("mypicture");
	    	OutputStream outputStream = new FileOutputStream("src//mypic.png");
	    	int len = -1;
	    	while((len = inputStream.read()) != -1) {
	    		outputStream.write(len);
	    	}
	    	outputStream.close();
	    	inputStream.close();
	    	System.out.println("图片读取成功！");
	      
	}  
    }
    
}

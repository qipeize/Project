package org.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String fileName = request.getParameter("fileName");
	   //设置消息头
	   response.addHeader("Content-Type","application/octet-stream");
	   String agent = request.getHeader("User-Agent");
	   if(agent.toLowerCase().indexOf("firefox") != -1) {
		   response.addHeader("Content-Disposition","attachment;fileName="
	                            +"=?UTF-8?B?"
				                +(new String(Base64.encodeBase64(fileName.getBytes("UTF-8"))))
				                +"?=");
	   }else {
		   response.addHeader("Content-Disposition","attachment;fileName="
	                           +URLEncoder.encode(fileName, "UTF-8"));
	   }
	  
//	   response.addHeader("Content-Type","application/octet-stream");
//	   response.addHeader("Content-Disposition","attachment;filename="+fileName);
	   InputStream in = getServletContext().getResourceAsStream("/jpg/"+fileName);
	   ServletOutputStream output = response.getOutputStream();
	   byte[] bs = new byte[1024];
	   int len = -1;
	   while((len = in.read(bs)) != -1) {
		   output.write(bs,0,len);
	   }
	   output.close();
	   in.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

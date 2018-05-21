package org.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
		//上传的文件名
		String filename = "";
		//表单字段元素的属性值
		String fieldName = "";
		//请求信息request中的 内容是否是multipart类型
		boolean multipart = ServletFileUpload.isMultipartContent(request);
		//上传文件的存储路径
//		String uploadFilePath = request.getSession().getServletContext().getRealPath("upload");
		if(multipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {
				//解析form表单中所有字段元素
				List<FileItem> items = upload.parseRequest(request);
				//遍历form表单中的字段元素
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()) {
					FileItem fileItem = iter.next();
					//判断是都是普通字段
					if(fileItem.isFormField()) {
						//获取表单中的name属性
						fieldName = fileItem.getFieldName();
						//依次处理每个字段
						if(fieldName.equals("sno")) {
							int sno = Integer.parseInt(fileItem.getString("utf-8"));
						}else if(fieldName.equals("sname")) {
							String sname = fileItem.getString("utf-8");
							
						}
					}else {//文件表单字段
						//获取正在上传的文件名
					   filename = fileItem.getName();
						if(filename != null && filename != "") {
	
							File file = new File("D:\\upload",filename);
							try {
								fileItem.write(file);
							} catch (Exception e) {
								e.printStackTrace();
							}
							System.out.println("文件上传成功！");
							return;
						}
					}
				}
			} catch (FileUploadException e) {
				
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

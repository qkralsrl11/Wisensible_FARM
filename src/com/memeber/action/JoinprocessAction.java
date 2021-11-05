package com.memeber.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Action;
import com.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class JoinprocessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String realFolder="";
		
		//Webcontent 아래에 폴더 생성하
		String saveFolder="memberupload";
		
		int fileSize = 5*1024*1024; //업로드 할 파일의 최대 사이즈 5MB
		
		//실제 저장졍로지정
		ServletContext sc = request.getServletContext();
		realFolder = sc.getRealPath(saveFolder);
		System.out.println("realFolder = " + realFolder);
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());
			
			
			String M_id = multi.getParameter("id");
			String M_name =multi.getParameter("name");
			String M_pass = multi.getParameter("pass");
			String birth = multi.getParameter("birth1") + " / " + multi.getParameter("birth2")
			+ " / " + multi.getParameter("birth3");
			String member_email = multi.getParameter("email") + "@"
					+ multi.getParameter("domain");
			String member_gender = multi.getParameter("gender");
			String tel1 = multi.getParameter("tel1");
			String tel2 = multi.getParameter("tel2");
			String tel3 = multi.getParameter("tel3");
			
			
		}
		
		
		return null;
	}

}

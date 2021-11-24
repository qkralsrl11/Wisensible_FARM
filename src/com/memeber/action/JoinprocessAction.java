package com.memeber.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Action;
import com.ActionForward;
import com.member.db.MemberDAO;
import com.member.db.MemberBean;
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
			String M_email = multi.getParameter("email") + "@"
					+ multi.getParameter("domain");
			String M_gender = multi.getParameter("gender");
			String tel = multi.getParameter("tel1")+"-"+ multi.getParameter("tel2")
						+"-"+ multi.getParameter("tel3");
			String bank = multi.getParameter("bank");
			String accountN = multi.getParameter("accountN");
			String postcode = multi.getParameter("post1");
			String address = multi.getParameter("address");
			String inter = multi.getParameter("interest");
			String pfph ="";
			
			System.out.println(M_id );
			System.out.println(M_name);
			System.out.println(M_pass);
			System.out.println(birth);
			System.out.println(M_email);
			System.out.println(M_gender);
			System.out.println(tel);
			System.out.println(bank);
			System.out.println(accountN);
			System.out.println(postcode);
			System.out.println(address);
			System.out.println(inter);
			System.out.println(pfph);
			
			
			
			
  			MemberBean mb = new MemberBean();
			mb.setMember_id(M_id);
			mb.setMember_name(M_name);
			mb.setMember_pass(M_pass);
			mb.setMember_birth(birth);
			mb.setMember_email(M_email);
			mb.setMember_gender(M_gender);
			mb.setMember_tel(tel);
			mb.setMember_bank(bank);
			mb.setMember_account(accountN);
			mb.setMember_post(postcode);
			mb.setMember_address(address);
			mb.setMember_i_ca(inter);
			mb.setMember_pfph(pfph);
			
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			
			MemberDAO md=  new MemberDAO();
			int result = md.insert(mb);
			System.out.println(result);
			
			out.println("<script>");
			if(result ==1) {
				out.println("alert('회원가입을 축하합니다.');");
				out.println("location.href='login.com';");
			}else if(result==-1) {
				out.println("alert('아이디가 중복되었습니다. 다시입력하세요.');");
				out.println("history.back()");
			}
			out.println("</script>");
			out.close();
			return null;
		} catch (IOException ex) {
			ex.printStackTrace();
			ActionForward forward = new ActionForward();
			forward.setPath("error/error.jsp");
			request.setAttribute("message", "프로필 사진 업로드 실패입니다.");
			forward.setRedirect(false);
			return forward;
		}
		
	}
}
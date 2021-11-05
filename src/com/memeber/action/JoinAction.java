package com.memeber.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Action;
import com.ActionForward;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("회원가입 페이지입니다.");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);//주소변경업이jsp페이지 내용 보여주기
		forward.setPath("member/joinform2.jsp");
		
		return forward;
	}

}

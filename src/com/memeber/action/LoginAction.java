package com.memeber.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Action;
import com.ActionForward;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인 페이지 입니다.");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("member/loginform.jsp");
		
		
		
		
		return forward;
	}

}

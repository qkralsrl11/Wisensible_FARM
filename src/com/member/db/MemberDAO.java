package com.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	
	private DataSource ds;
	
	public MemberDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception e) {
			System.out.println("DB연결 실패 : " + e);
			return;
		}
	}

	public int insert(MemberBean mb) {
	 
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = ds.getConnection();
			System.out.println("getConection : Insert()");
			
			String insert_sql = "INSERT INTO member"
					+ "(MEMBER_NAME, MEMBER_ID, MEMBER_PASS, MEMBER_BIRTH, MEMBER_GENDER,"
					+ "MEMBER_EMAIL, MEMBER_TEL, MEMBER_BANK, MEMBER_ACCOUNT, MEMBER_POST,"
					+ "MEMBER_ADDRESS, MEMBER_I_CA, MEMBER_PFPH)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			
			pstmt = con.prepareStatement(insert_sql);
			
			pstmt.setString(1, mb.getMember_name());
			pstmt.setString(2, mb.getMember_id());
			pstmt.setString(3, mb.getMember_pass());
			pstmt.setString(4, mb.getMember_birth());
			pstmt.setString(5, mb.getMember_gender());
			pstmt.setString(6, mb.getMember_email());
			pstmt.setString(7, mb.getMember_tel());
			pstmt.setString(8, mb.getMember_bank());
			pstmt.setString(9, mb.getMember_account());
			pstmt.setString(10, mb.getMember_post());
			pstmt.setString(11, mb.getMember_address());
			pstmt.setString(12, mb.getMember_i_ca());
			pstmt.setString(13, mb.getMember_pfph());
			
			result = pstmt.executeUpdate();
			
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			result = -1;
			System.out.println("멤버 아이디 중복 에러입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt !=null)
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if(con !=null)
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return result;
	}

	
	
	
	
	
	
	
	
}

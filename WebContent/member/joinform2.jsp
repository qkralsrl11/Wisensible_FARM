<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:include page="/board/header.jsp" />
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
</head>
<script src="js/jquery-3.5.1.js"></script>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="css/join.css" type="text/css" rel="stylesheet">

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script src="js/joinjs.js"></script>
<body>
<h1 id="jointitle">회원가입</h1>
<form name="joinform2" action="joinprocess2.com" method="post" enctype="multipart/form-data">
	<div class="container">
		<fieldset>
		<div class="inputclass">
		<b>이름</b>
		<input type="text" name="name" placeholder="Enter name" required maxlength="15">
		
		<b>아이디</b>
		<input type="text" name="id" placeholder="Enter Id" required maxlength="15">
		<span id="idck"></span>
		
		<b>비밀번호</b>
		<input type="text" name="pass" placeholder="Enter password" required maxlength="15">
		<b>비밀번호확인</b>
		<input type="text" name="psck" placeholder="Enter password" required maxlength="15">
		</div>
		<b>생년월일</b>
		<select name=birth1 id="birth1">
			<%for(int i=2030; i>=1930; i--){ %>
		 <option value="<%=i %>"><%=i %></option>
		 	<%} %>
		</select>&nbsp;년&nbsp;
		<select name=birth2 id="birth2">
		<%for(int i=1; i<=12; i++){ %>
       			<option value="<%=i %>"><%=i %></option>
       			<%} %>
		</select>&nbsp;월&nbsp;
		<select name=birth3 id="birth3">
		<%for(int i=1; i<=31; i++){ %>
       			<option value="<%=i %>"><%=i %></option>
       			<%} %>
		</select>&nbsp;일&nbsp;
		
		<b>성별</b>
		<input type="radio" name="gender" value="남" checked><span>남자</span>
		<input type="radio" name="gender" value="여" ><span>여자</span>
		
		<b>E-Mail</b>
		  <input type="text" name="email"	id="email">&nbsp;&nbsp;@&nbsp;
        <input type="text" name="domain" id="domain">
         <select name="sel" id="sel" >
        	<option value="">직접입력</option>
        	<option value="naver.com">naver.com</option>
        	<option value="daum.net">daum.net</option>
        	<option value="nate.com">nate.com</option>
        	<option value="gmail.com">gmail.com</option>
        </select>
		
		
		<b>연락처</b>
		<input type="text" name="tel1" id="tel1">&nbsp;-
		<input type="text" name="tel2" id="tel2">&nbsp;-
		<input type="text" name="tel3" id="tel3">
		
		
		<b>계좌번호</b>
		<select name="bank" id="bank">
		<option value="신한은행"> 신한은행</option>
		<option value="국민은행"> 국민은행</option>
		<option value="하나은행"> 하나은행</option>
		<option value="우리은행"> 우리은행</option>
		<option value="카카오은행"> 카카오은행</option>
		<option value="농협"> 농협</option>
		</select>
		<input type="text" name=accountN id="accountN" placeholder="계좌번호를 입력해주세요" >
		
		
		
		<b>우편번호</b>
		<input type="text" size="5" maxlength="5" name="post1" id="post1">
		<input type="button" value="우편검색" id="postcode">
		
		<b>상세주소</b>
		   <input type="text" size="50" name="address" id="address"> 
		
		
		
		<b>흥미 있는 카테고리</b>
		<input type="checkbox" name="interest" id="hobby1" value="채소">채소&nbsp;&nbsp;&nbsp;
        	<input type="checkbox" name="interest" id="hobby2" value="곡물">곡물&nbsp;&nbsp;&nbsp;
        	<input type="checkbox" name="interest" id="hobby3" value="과일">과일&nbsp;&nbsp;&nbsp;
        	<input type="checkbox" name="interest" id="hobby4" value="해산물">해산물&nbsp;&nbsp;&nbsp;
        	<input type="checkbox" name="interest" id="hobby5" value="축산물">축산물&nbsp;&nbsp;&nbsp;
		
		<b>프로필사진</b>
		
		
		<div class="clearfix">
			<button type="reset" class="cancelbtn">다시작성</button>
			<button type="submit" class="submitbtn">회원가입</button>
		
		</div>
		
	
	
		</fieldset>
	</div>
</form>
</body>
<jsp:include page="/board/footer.jsp" />
</html>
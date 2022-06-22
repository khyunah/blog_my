<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
	<form action="/action_page.php" class="m-5">
	  <div class="form-group">
	    <label for="id">아이디:</label>
	    <input type="text" class="form-control w-25" placeholder="id를 입력하세요" id="id">
	  </div>
	  <div class="form-group">
	    <label for="pwd">비밀번호:</label>
	    <input type="password" class="form-control w-25" placeholder="비밀번호를 입력하세요" id="pwd">
	  </div>
	  <div class="form-group">
	    <label for="email">이메일:</label>
	    <input type="email" class="form-control w-25" placeholder="email을 입력하세요" id="email">
	  </div>
  	  <button id="btn-join" type="button" class="btn btn-primary">회원가입</button>
	</form> 
<script src="/myblog/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
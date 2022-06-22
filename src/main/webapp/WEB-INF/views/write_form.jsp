<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>

<div class="container">
	<form action="">
		<div class="form-group">
			<label for="title">Title : </label>
			<!-- 폼태그 서브밋으로 넘기려면 name="title" 네임 값 잇어여ㅑ함 -->
			<input type="text" class="form-control" placeholder="title" id="title">
		</div>
		
		<div class="form-group">
			<label for="content">Content : </label>
			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>
		<br/>
		<button id="btn-write" type="button" class="btn btn-primary">글쓰기</button>
	</form>
</div>
<br/>

<script src="/myblog/js/board.js"></script>
<%@ include file="layout/footer.jsp"%>
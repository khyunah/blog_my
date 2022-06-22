let join = {
	
	init: function(){
		$("#btn-join").bind("click", () => {
			this.join();
		})
		
		$("#btn-login").bind("click", () => {
			this.login();
		})
	},
	
	join: function(){
		let data = {
			username: $("#id").val(),
			password: $("#pwd").val(),
			email: $("#email").val()
		}
		console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/myblog/api/user",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(){
			// 성공시
			alert("회원가입에 성공했습니다.");
			location.href = "/myblog";
		}).fail(function(){
			// 실패시
			alert("회원가입에 실패했습니다.");
		});
	},
	
	login: function(){
		let data = {
			username: $("#id").val(),
			password: $("#pwd").val()
		}
		
		$.ajax({
			type: "POST",
			url: "/myblog/api/user/login",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(){
			alert("로그인 되었습니다");
			location.href = "/myblog/list"
		}).fail(function(){
			alert("로그인에 실패했습니다.");
		});
	}
	
}

join.init();
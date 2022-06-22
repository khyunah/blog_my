let save = {
	
	init: function(){
		console.log("init()들어옴");
		document.querySelector("#btn-write").addEventListener("click", function(){
			let data = {
				title: document.querySelector("#title").value,
				content: document.querySelector("#content").value
			}
			
			fetch("/myblog/save", {
				method: "post",
				headers: {
					"content-type":"application/json; charset=utf-8"
				},
				body: JSON.stringify(data)
			}).then(res => res.text())
			.then(res => {
				if(res == "ok"){
					alert("글쓰기 저장 성공");
					location.href = "/myblog/list";
				} else{
					alert("글쓰기 저장 실패");
				}
			});
		});
	}
}
	$('.summernote').summernote({
	    placeholder: 'Hello Bootstrap 4',
	    tabsize: 2,
	    height: 300
	});

save.init();

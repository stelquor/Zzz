/*
	
	 =================================================================
 	================= boardUpdate.html의 javascript 파일 =================
	 =================================================================
 	
 */

 
 $('#board_content').summernote('code', '${board_data.BOARD_CONTENT}');
 
 
 function unPwCheck(){
	var unPwForm = document.unPwForm
	let unPwCheck={b_pw:$('#unBPw').val()}
 	$.ajax({
		method:'get',
		url: '/board/unPwCheck',
		data: unPwCheck,
	}).done(function(res){
		console.log("res: ",res);
		if (res=="ok"){
			
		}else{
			
		}
	}).fail((err,status)=>{
		console.log("err:", err);
		console.log("status:", status);
		return false
	})
 }
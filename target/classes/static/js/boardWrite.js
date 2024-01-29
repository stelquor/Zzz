/*
	
	 =================================================================
 	================= boardWrite.html의 javascript 파일 =================
	 =================================================================
 	
 */



function anonymousChange(){
	let nick = document.getElementById('nicknameBTN')
	let anony = document.getElementById('anonymousBTN')
	if(nick.className=='btn btn-primary'){
		nick.className = 'btn btn-outline-primary';
		anony.className = 'btn btn-primary';
		$('#b_writerNick').css('display','block')
	}else{
		nick.className = 'btn btn-primary';
		anony.className = 'btn btn-outline-primary';
		$('#b_writerNick').css('display','none')
	}
}



function writeCheck() {		// 게시글 올리기 전 체크
	let anony = document.getElementById('anonymousBTN')
	let title = $('#b_title').val()
	var contents = $('#summernote').summernote('code')
	
/*	if(anony.className=='btn btn-primary'){
		let nick = $('#b_writerNick').val()
		let unNickCheck={b_writerNick:nick}
	 	$.ajax({
			method:'get',
			url: '/board/unNickCheck',
			data: unNickCheck,
		}).done(function(res){
			console.log("res: ",res);
			if (res!="ok"){
				$('#').html('회원가입된 닉네임은 사용할 수 없습니다.')
				return false
			}
		}).fail((err,status)=>{
			console.log("err:", err);
			console.log("status:", status);
			return false
		})
	}*/
	if (title == '') {
		Swal.fire({
			icon : "error",
			title : "Oops...",
			text : "제목은 비워둘 수 없습니다.",
		});
		return false
	} else if (title.length > 15) {
		Swal.fire({
			icon : "error",
			title : "Oops...",
			text : "제목은 15글자까지 작성할 수 있습니다.",
		});
		return false
	} else if (contents == '<p><br></p>') {
		Swal.fire({
			icon : "error",
			title : "Oops...",
			text : "내용은 비워둘 수 없습니다.",
		});
		return false
	}
	return true
}		// 게시글 올리기 전 체크 끝



/* ====================== 썸머노트 설정 시작 ====================== */
$(document).ready(function() {
	$('#summernote').summernote({
		lang : 'ko-KR' // default: 'en-US'
	});
});

$('#summernote').summernote({
	placeholder : '게시글을 작성해주세요.',
	tabsize : 2,
	height : 400,
	toolbar : [ [ 'style', [ 'style' ] ],
			[ 'font', [ 'bold', 'underline', 'clear' ] ],
			[ 'color', [ 'color' ] ],
			[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
			[ 'table', [ 'table' ] ],
			[ 'insert', [ 'link', 'picture', 'video' ] ],
			[ 'view', [ 'fullscreen', 'codeview', 'help' ] ] ]
});
/* ====================== 썸머노트 설정 끝 ====================== */
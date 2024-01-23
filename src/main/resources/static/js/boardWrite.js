/*
	
	 =================================================================
 	================= boardWrite.html의 javascript 파일 =================
	 =================================================================
 	
 */


function writeCheck() {		// 게시글 올리기 전 체크
	let title = $('#b_title').val()
	var contents = $('#summernote').summernote('code')

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


function anonymousChange(){
	let nick = document.getElementById('nicknameBTN')
	let anony = document.getElementById('anonymousBTN')
	if(nick.className=='btn btn-primary'){
		nick.className = 'btn btn-outline-primary';
		anony.className = 'btn btn-primary';
	}else{
		nick.className = 'btn btn-primary';
		anony.className = 'btn btn-outline-primary';
	}
}
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>
<link href="/resources/css/com_register.css" rel="stylesheet">
<script>
$(document).ready(function() {
	
	var setting = {
			placeholder: 'content',
	        height: 450,  
	        minHeight: 370,
	        maxHeight: 500,
	        focus: true, 
	        lang : 'ko-KR',
	        callbacks: {
	        	onImageUpload : function(files){
	        		sendFile(files[0],this);
	        	}
	        }
	};
	
    $('#summernote').summernote(setting);
     
   });
   
function sendFile(file, editor){
	var data = new FormData();
	data.append("file", file);
	console.log("file : "+file);
	console.log("data : "+data);
	$.ajax({
		data : data,
		type : "POST",
		url : "/community/SummerNoteImageFile",
		contentType : false,
		processData : false,
		enctype : 'multipart/form-data',
		error : function() {
			console.log("파일 에러!!");
		},
		success : function(url){
			console.log(url);
			console.log(editor);
			$(editor).summernote("insertImage",url);
		}
	});
}
</script>
<title>register</title>
</head>
<body>
   
   <div class="container">
        
        <!-- 좌측/ 전체 동일한 메뉴바 부분 -->
       <div class="left">
           <img src="/resources/img/logo.png" class="logo" alt="">
           <div class="menu_bar">
               <button><a href="/menu/home"> 🏠<span> Home</span></a></button><br>
                <button><a href="/sj/title?sub_num=1">📝<span> Subject</span></a></button><br>
               <button><a href="/community/communitypage">📖<span class="not"> Community</span></a></button><br>
               <button><a href="/menu/qna">📁<span> Q&A</span></a></button><br>
            </div>
            <div class="sebu">
                <button><a href="">⚙ Setting</a></button><br>
                <button><a href="/main/end">🗑 Log out</a></button><br>
            </div>
        </div>
     
        <!-- 우측/ Comment 부분 -->
        <div class="right">
        
        
           <div class="wcontent">
                 
            <div class="wleft">
               
               <div class="head">
                  <a href="/community/communitypage">
                     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" color="white" fill="currentColor" class="bi bi-chevron-left" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
                     </svg>
                  </a>
                  <h4>게시글 작성</h4>
               </div>  
                 
               <div class="title">
                  <p>제목</p>
                  <input type="text"  id="com_title" placeholder="제목을 입력해주세요">
               </div>
               
               <div>
                  <p>닉네임</p>
                  <input type="text" id="nickname" value="${ses.nickname}" readonly="readonly" >
                  <input type="hidden" id="id" value="${ses.id}">
               </div>
               
               <div>
                  <p>작성일자</p>
                  <input type="text" name="com_reg_date" id="com_reg_date" readonly="readonly">
               </div>
               
               <div>
               	   <p>카테고리</p>
	               <div class="category">
	             		<input type="radio" id="category1" name="com_category" checked="checked" value="개발"><label for="category1">개발</label>
	     				<input type="radio" id="category2" name="com_category" value="상담"><label for="category2">상담</label>
	               </div>  
               </div>
               
             	<form action="/community/file" method="post" enctype="multipart/form-data">
	               <div class="file_list">
	                  <hr>
	                  <p>파일</p>
	                  
	                  <input type="file" name="files" id="file" style="display:none">
	                  <button type="button" id="trigger">썸네일 첨부 + </button>
	               	  <div id="filezone">
	               	  	<!-- 파일이 출력되는 자리 -->
	               	  </div>
	               </div>
	               <button type="submit" id="subThumbBtn" style="display: none;"></button>
            	</form>
            	
               <div class="line"></div>
            
            </div>
            
            <div class="wright">
	            <div class="wtitle">
	                <h4>✍ 상세 설명</h4>
	                <input type="button" class="wbutton" value="자리" style="visibility: hidden;"/>
	                <input id="subBtn" type="button" value="저장" class="wbutton"/>
	            </div>
	               <!-- 썸머노트 들어갈 곳 -->
	            <div style=" margin: auto;" class="summer">
	                     <textarea id="summernote"></textarea>
	            </div>
           	</div>
    
      	</div>
       
      </div>
      	
     <script type="text/javascript" src="/resources/js/community_reg.js"></script>
     <script type="text/javascript">
	     let today = new Date();
	     let year = today.getFullYear();
	     let month = ('0' + (today.getMonth() + 1)).slice(-2);
	     let day = ('0' + today.getDate()).slice(-2);
	
	     let com_reg_date = year + '-' + month  + '-' + day;
	     
	     document.getElementById("com_reg_date").value = com_reg_date;
	     
     </script>

     
</body>
</html>
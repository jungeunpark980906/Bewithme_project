<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link href="/resources/css/register2.css" rel="stylesheet">
<script>
$(document).ready(function() {
	   
	   var setting = {
	         placeholder: 'content',
	           height: 450,  
	           minHeight: 370,
	           maxHeight: 500,
	           focus: true, 
	           lang : 'ko-KR',
	           callbacks : {
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
		$.ajax({
			data : data,
			type : "POST",
			url : "/co/SummerNoteImageFile",
			contentType : false,
			processData : false,
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

<script>
function goWrite(frm) {
	var title = frm.title.value;
	var writer = frm.writer.value;
	var content = frm.content.value;
	
	if (title.trim() == ''){
		alert("제목을 입력해주세요");
		return false;
	}
	if (writer.trim() == ''){
		alert("작성자를 입력해주세요");
		return false;
	}
	if (content.trim() == ''){
		alert("내용을 입력해주세요");
		return false;
	}
	frm.submit();
}
</script>
<title>register</title>
</head>
<body>
   
   <div class="container">
        
        <!-- 좌측/ 전체 동일한 메뉴바 부분 -->
        <div class="left">
            <a href="/menu/home"><img src="/resources/img/logo.png" class="logo" alt=""></a>
            <div class="menu_bar">
                <button><a href="/menu/home"> 🏠<span> Home</span></a></button><br>
                <button><a href="/sj/title?sub_num=1">📝<span class="not"> Subject</span></a></button><br>
                <button><a href="/menu/community">📖<span> Community</span></a></button><br>
                <c:choose>
                	<c:when test="${ses.id eq 'admin'}">
                		<button><a href="/menu/qna_admin">📁<span> Q&A</span></a></button><br>            	
                	</c:when>
                	<c:otherwise>
                		<button><a href="/menu/qna">📁<span> Q&A</span></a></button><br>            	
                	</c:otherwise>
                </c:choose>
            </div>
            <div class="sebu">
                <button><a href="https://school.programmers.co.kr/learn/challenges?order=recent&levels=0&languages=java&page=1" target="_blank">⚙ Coding Test</a></button><br>
                <button><a href="/main/end">🗑 Log out</a></button><br>
            </div>
        </div>
        <form action="/co/modify" method="post">
        <!-- 우측/ Comment 부분 -->
        <div class="right">
        
        
           <div class="wcontent">
                 
            <div class="wleft">
               
               <div class="head">
                  <a>
                     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" color="white" fill="currentColor" class="bi bi-chevron-left" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
                              </svg>
                  </a>
                  <h4>게시글 작성</h4>
               </div>  
                 <input type="hidden" name="sub_num" value="${msg.sub_num}">
                 <input type="hidden" name="cou_num" value="${msg.cou_num}">
               <div class="title">
                  <p>제목</p>
                  <input type="text" name="cou_title" placeholder="제목을 입력해주세요" value="${msg.cou_title}" >
               </div>
               
               <div>
                  <p>닉네임</p>
                  <input type="text" name="id" value="${ses.id }">
                  <!-- readonly="readonly"  placeholder="정은" --> 
               </div>
               
               <div>
                  <p>작성일자</p>
                  <input type="text" name="cou_reg_date">
                  <!-- readonly="readonly"  placeholder="2023-07-08" -->
               </div>
               
               <div class="file_list">
                        <hr>
                        <p>요약문</p>
                  <input type="text" name="summary" value="${msg.summary}">
               </div>
               
               <div class="line"></div>
            </div>
            
            
      
               <div class="wright">
               <div class="wtitle">
                  <h4>✍ 상세 설명</h4>
<!--                   <input id="subBtn" type="button" value="저장" class="wbutton"
                     onclick="location.href='/write'" /> -->
                     <button id="subBtn"  class="wbutton">저장</button>
               </div>
               <!-- 썸머노트 들어갈 곳 -->
               <div style=" margin: auto;" class="summer">
                     <textarea id="summernote" name="cou_content">${msg.cou_content }</textarea>
               </div>
            </div>
         
         
      </div>
       
      
      </div>
 </form>
      
      <script type="text/javascript">
      
      const date = new Date();

      const year = date.getFullYear();
      const month = ('0' + (date.getMonth() + 1)).slice(-2);
      const day = ('0' + date.getDate()).slice(-2);
      const dateStr = year + '-' + month + '-' + day;

      console.log(dateStr);
      
      document.querySelector('input[name="cou_reg_date"]').value = dateStr;
      
      </script>
</body>
</html>
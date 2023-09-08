<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/bookmark.css">
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

        <!-- 우측/ list 부분 -->
        <div class="right">
          
            <div class="top">
                <div class="list_count" id="list_count">
                    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="25" fill="currentColor" class="bi bi-archive" viewBox="0 0 16 16">
                        <path d="M0 2a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 12.5V5a1 1 0 0 1-1-1V2zm2 3v7.5A1.5 1.5 0 0 0 3.5 14h9a1.5 1.5 0 0 0 1.5-1.5V5H2zm13-3H1v2h14V2zM5 7.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
                    </svg>
                    나의 강의 <span>0</span>
                </div>
                <!-- <button class="deleteAll">전체 삭제</button> -->
            </div>

			<div class="tableSize">
	            <table class="list" id="list">
	                <tr>
	                    <th>강의 과목</th>
	                    <th>강의 명</th>
	                </tr>
	           
	                
	                <tr>
	                    <td>HTML,CSS</td>
	                    <td>
	                        <div>
	                            <span style="display: hidden;" id="cou_num">1-1</span>
	                            <a href="#">VSCODE 설치</a>
	                        </div>
	                        <button type="button" id="delBtn">
	                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
	                                <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
	                            </svg>
	                        </button> 
	                    </td>
	                </tr>
	             
	            </table>
     		</div>



        </div><!--class="right"-->


    </div>
    <script src="../resources/js/bookmark.js"></script>
    <script type="text/javascript">
    	getBookmarkList();
    </script>
</body>
</html>
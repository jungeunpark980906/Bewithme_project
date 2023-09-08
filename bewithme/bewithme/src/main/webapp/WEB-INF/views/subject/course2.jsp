<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>course</title>
    <link rel="stylesheet" href="/resources/css/menu.css">
    <link rel="stylesheet" href="/resources/css/course.css">
</head>

<body>
    <div class="container">
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
       <%--  <form action="/co/link?cou_num=${cvo.cou_num}" method="post"> --%>
        <div class="right" id="course2">
        
        <div class="co_bookmark" >
            <h1>${cvo.cou_title}</h1>
        <div id="bookmark" class="bookmark">
            <button class="bookmarkBtn" id="bkt"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="white"  viewBox="0 0 16 16">
  <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z"/>
</svg></button>
        
        </div>    
            
        </div>
            <div class="co_t">
                <span>조회수 ${cvo.cou_cnt} · 4분 분량 </span><span>${cvo.cou_reg_date}</span>
            </div>

           <div class="ex">
                🧑‍💻 <b>${cvo.summary}</b>
            </div>
            
            <div class="cou_content">
				<p >${cvo.cou_content}</p>            
            </div>





            <hr>
            <!-- 해당 댓글 -->
            <div class="comment">

                <div class="comment_count">
                    댓글 <!-- <span>2</span> -->
                </div>
                
                <!--작성부분-->
                <div class="comment_write">
                    <textarea id="couText" placeholder="내용을 입력해 주세요." maxlength="250" wrap="soft"></textarea>
                    <div class="cw_line"></div>
                    <div>
                        <span>${ses.nickname}</span>
                        <button type="button" id="couPostBtn">작성하기</button>
                    </div>
                </div>

                <!--댓글리스트 출력부분-->
                <div class="comment_list" id="cou_commnetlist">

                    <div class="comment_content">
                     <!--    <div class="nickname">먼저댓글정은</div>
                     <div>게시글 댓그르 첫번째 입니다.</div>
                        <input type="text" id="cou_comment"></input>

                        <div>
                            <div>
                                <span>23.07.03 •</span>
                                <svg xmlns="http://www.w3.org/2000/svg" width="12" height="10" fill="currentColor"
                                    class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
                                    <path
                                        d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z" />
                                </svg>
                                <span>1</span>
                                <span> • 수정됨</span>
                            </div>
								<button type="button" class="modBtn">수정&nbsp;&nbsp;&nbsp;|</button>
								<button type="button" class="delBtn"> 삭제</button> 
                            <button class="like_button">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                    class="bi bi-suit-heart" viewBox="0 0 16 16">
                                    <path
                                        d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
                                </svg>
                            </button>

                        </div>
                        <div class="comment_line"></div> -->
                    </div>                 
                </div>

            </div><!--class="comment"-->







        </div>
<!-- </form> -->
    </div>

    <script type="text/javascript" src="/resources/js/course_comment.js">
    </script>
    
    <script type="text/javascript">
    const cnoVal = '<c:out value="${cvo.cou_num}" />';
    const id = '<c:out value="${ses.id}" />';
    const nickname = '<c:out value="${ses.nickname}" />';
    const admin = '<c:out value="${ses.admin}" />';
    const isOk = '<c:out value="${isOk}" />';
    
    console.log("cou_num : "+cnoVal);
    console.log("id: "+id);
    </script>
    
	<script type="text/javascript">
	couCommentList(cnoVal);
	getBookmarkList(cnoVal);





	</script>
	
	 

	

</body>

</html>
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
            <img src="/resources/img/logo.png" class="logo" alt="">
            <div class="menu_bar">
<<<<<<< HEAD
                <button><a href=""> 🏠<span> Home</span></a></button><br>
                <button><a href="/subject.jsp">📝<span class="not"> Subject</span></a></button><br>
                <button><a href="">📖<span > Community</span></a></button><br>
                <button><a href="">📁<span> Q&A</span></a></button><br>
=======
                <button><a href="/menu/home"> 🏠<span> Home</span></a></button><br>
                <button><a href="/menu/subject">📝<span class="not"> Subject</span></a></button><br>
                <button><a href="/menu/community">📖<span> Community</span></a></button><br>
                <c:choose>
                	<c:when test="${ses.id eq 'admin'}">
                		<button><a href="/menu/qna_admin">📁<span> Q&A</span></a></button><br>            	
                	</c:when>
                	<c:otherwise>
                		<button><a href="/menu/qna">📁<span> Q&A</span></a></button><br>            	
                	</c:otherwise>
                </c:choose>
>>>>>>> c8c390bdb8bc1777844559db7184836c613d536d
            </div>
            <div class="sebu">
                <button><a href="">⚙ Setting</a></button><br>
                <button><a href="/member/logout">🗑 Log out</a></button><br>
            </div>
        
        </div>
        <div class="right">
            <h1>Visual Studio Code 설치 및 사용법(한국어팩, Live Server, 파이썬 설치, 단축키 설정)</h1>

            <div class="co_t">
                <span>조회수 · 4분 분량 </span><span>2023.06.30</span>
            </div>

            <div class="ex">
                🧑‍💻 코딩 공부의 첫 발을 내딛기 위해서 필요한 것들이 있습니다. 그중 하나가 컴퓨터 안에 개발 환경을 구축하는 것인데요. 0과 1밖에 모르는 컴퓨터와 사람 사이에 통역가를 두는
                일이죠. 그 역할을 하는 프로그램 중 하나가 바로 Visual Studio Code(이하 VS Code)입니다. 설치 후에 간단한 설정을 끝내면 쉽게 이용할 수 있어요. 이번 콘텐츠에서
                설치 방법부터 초기 설정까지 한번에 확인해 보세요.
            </div>

            <h2>1. Visual Studio Code vs Visual Studio</h2>
            <h3>Visual Studio Code란?</h3>
            <p>Visual Studio Code는 마이크로소프트 사에서 개발한 코드 편집이 가능한 에디터입니다. 문서 작업을 할 때 word를 사용하는 것처럼 코딩을 할 때는 VS Code와 같은 코드
                편집 프로그램을 사용합니다.

                본래 에디터기 때문에 사용자가 커스텀을 통해 적합한 개발 환경을 구축해야 하죠. VS Code는 가벼워 대부분의 사양에서 사용이 가능합니다. 또한 프로그래밍 언어의 범용성이 좋아,
                대중적으로 사용되고 있습니다.
            </p>

            <blockquote>
                🔍 Visual Studio와 Visual Studio Code는 같은 건가요?<br>
                Visual Studio는 IDE(Intergrated Development Environment)입니다. IDE는 통합 개발 환경으로 개발과 관련된 모든 작업을 수행할 수 있는
                공간인데요. VS Code와 달리 내부적인 환경을 구축하지 않아도 사용이 가능합니다. 그러나 프로그램이 다소 무겁기 때문에 용량이 매우 크고 설치 과정도 복잡합니다.
            </blockquote>

            <p>이제 VS Code를 설치하러 가볼까요?</p>

            <h2>2. VSC 설치법</h2>
            <p>VS Code 사이트에 접속해 주세요.</p>
            <p>VS Code 바로가기 <a href="https://code.visualstudio.com/">👉 https://code.visualstudio.com/</a></p>
            <p>사이트에 접속을 하면 다음과 같은 화면이 나타납니다. 빨간색 박스에서 자신의 운영체제에 맞는 옵션을 골라 다운로드하면 됩니다.</p>
            <img src="/resources/img/vs1.png" alt="">

            <blockquote>
                🔍 Stable / Insiders 중에 무엇을 다운로드해야 하나요?<br>
                Stable을 추천해요. Stable은 버그 발생률을 줄인 안정된 버전입니다. Insiders은 최신 버전이지만, 불안정하여 여러 버그가 나타날 수 있습니다. 대부분의 사용자에게
                Stable가 적합합니다.
            </blockquote>

            <p>다운을 받으면 1)과 같은 파일이 보이는데요. 더블 클릭을 해주면 압축이 해제되면서 2)가 생성됩니다.</p>
            <img src="/resources/img/vs2.png" alt="">
            <p>2)를 더블클릭 하면 아래와 같은 창이 뜨며 VS Code를 이용할 수 있습니다.</p>
            <img src="/resources/img/vs3.png" alt="">
            <br><br><br>
            <!-- 댓글 -->

            <!-- <div class="com">
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-chat-left-dots" viewBox="0 0 16 16">
                    <path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H4.414A2 2 0 0 0 3 11.586l-2 2V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                    <path d="M5 6a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
                </svg>
                <h4>댓글</h4>
            </div>
            <hr>

            <div class="commentt">
                <div class="comimg">B</div>
                <input type="text" class="comlist" placeholder="    댓글을 입력해주세요">
                <button type="submit" class="combtn">등록</button>
            </div> -->

            <hr>
            <!-- 해당 댓글 -->
            <div class="comment">

                <div class="comment_count">
                    댓글 <span>2</span>
                </div>
                
                <!--작성부분-->
                <div class="comment_write">
                    <textarea placeholder="내용을 입력해 주세요." maxlength="250" wrap="soft"></textarea>
                    <div class="cw_line"></div>
                    <div>
                        <span>댓글을달아요정은</span>
                        <button type="submit">작성하기</button>
                    </div>
                </div>

                <!--댓글리스트 출력부분-->
                <div class="comment_list">

                    <div class="comment_content">
                        <div>먼저댓글정은</div>
                        <div>게시글 댓그르 첫번째 입니다.</div>

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

                            <button class="like_button">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                    class="bi bi-suit-heart" viewBox="0 0 16 16">
                                    <path
                                        d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
                                </svg>
                            </button>

                        </div>
                        <div class="comment_line"></div>
                    </div>

                    <div class="comment_content">
                        <div>먼저댓글정은</div>
                        <div>게시글 댓그르 두번째 입니다. 이 댓글은 긴글을 확인하기 위해 작성중이며
                            어느정도의 길이까지가 작성이 가능하고, 보여지는지 확인하기 위한 댓글입니다.
                            길이를 한 어느정도까지 보이도록 해놓아야하지? 보여줄길이와 작성 길이 추후에 맞추기!
                        </div>

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

                            <button class="like_button">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                    class="bi bi-suit-heart" viewBox="0 0 16 16">
                                    <path
                                        d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
                                </svg>
                            </button>

                        </div>
                        <div class="comment_line"></div>
                    </div>

                    <div class="comment_content">
                        <div>먼저댓글정은</div>
                        <div>게시글 댓그르 세번째 입니다.</div>

                        <div>
                            <div>
                                <span>23.07.03 •</span>
                                <svg xmlns="http://www.w3.org/2000/svg" width="12" height="10" fill="currentColor"
                                    class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
                                    <path
                                        d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z" />
                                </svg>
                                <span> 1</span>
                                <span> • 수정됨</span>
                            </div>

                            <button class="like_button">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                    class="bi bi-suit-heart" viewBox="0 0 16 16">
                                    <path
                                        d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" />
                                </svg>
                            </button>

                        </div>
                        <div class="comment_line"></div>
                    </div>


                </div>

            </div><!--class="comment"-->







        </div>

    </div>
</body>

</html>

// -- 북마크 리스트 출력 --

//DB에서 정보 map으로 가져오기
async function spreadBookmarkListFromServer(){
    try {
        const resp =  await fetch('/bookmark/bookmarkList');
        const result = await resp.json();
        return result;
    } catch (error) {
        console.log("bookmark.js에서 전송 오류" + error)
    }
  }
  
  
//가져온 정보list 화면에 뿌리기
function getBookmarkList(){
 
    spreadBookmarkListFromServer().then(result => {

        console.log("Controller(DB) -> JS / CourseList: " + (( result.CourseList.length > 0 )? "OK":"FAIL"));
        console.log("Controller(DB) -> JS / BookmarkList : " + (( result.BookmarkList.length > 0 )? "OK":"FAIL"));

        const table = document.getElementById("list");
        const listCnt = document.getElementById("list_count"); //나의 강의 수

        if (result.CourseList.length > 0) {

            table.innerHTML = "";
            let tr = `<tr>
                        <th>강의 과목</th>
                        <th>강의 명</th>
                    </tr>`;
            let isBookmark = true;
            let cnt = 0;
            for(let cvo of result.CourseList){
                for(let num of result.BookmarkList){
                    if(cvo.cou_num == num){
                        tr += `<tr>`;
                        //과목 번호 구분 출력
                        switch (cvo.sub_num) {
                            case 1:
                                tr += `<td>HTML/CSS</td>`;
                                break;
                            case 2:
                                tr += `<td>JAVASCRIPT</td>`;
                                break;
                            case 3:
                                tr += `<td>JAVA</td>`;
                                break;
                            case 4:
                                tr += `<td>MYSQL</td>`;
                                break;
                            case 5:
                                tr += `<td>JSP</td>`;
                                break;
                            case 6:
                                tr += `<td>SPRING</td>`;
                                break;
                            default:
                                tr += `<td>-</td>`;
                                break;
                        }
                        tr += `<td>`;
                        tr += `<div>
                                    <a href="#">${cvo.cou_title}</a>
                                </div>`;
                        tr += `<button type="button" class="delBtn" value="${cvo.cou_num}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
                                        <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
                                    </svg>
                                </button> `;
                        tr += `</td>`;
                        tr += `</tr>`;
                        table.innerHTML = tr;
                        isBookmark = false;
                        cnt ++;
                    }

                }
            }

            if(isBookmark){
                table.innerHTML = "<div>담은 강의가 없습니다.</div>";
            } 

            //나의 강의 수 출력
            listCnt.innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" width="30" height="25" fill="currentColor" class="bi bi-archive" viewBox="0 0 16 16">
                                        <path d="M0 2a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 12.5V5a1 1 0 0 1-1-1V2zm2 3v7.5A1.5 1.5 0 0 0 3.5 14h9a1.5 1.5 0 0 0 1.5-1.5V5H2zm13-3H1v2h14V2zM5 7.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
                                    </svg>
                                    나의 강의 <span>${cnt}</span>`;
            

        }else{
            table.innerHTML = "<div>강의가 존재하지않습니다.</div>";
        }

    })

}

//--------------------------------------------------------------------------------------------------
// -- 북마크 삭제 --

//담은 강의 삭제 (북마크 삭제)
async function deleteBookmarkFromServer(cou_num){
	try {
		const url = "/bookmark/"+ cou_num;
		const config={
			method: "delete",
			headers: {
				'Content-Type' : 'application/json; charset=utf-8'
			}
		}
		const resp = await fetch(url, config);
		const result = await resp.text();  
		return result;
	} catch (error) {
		console.log(error);
	}
}


//삭제 버튼 이벤트
document.addEventListener('click', (e)=>{ 
	if(e.target.classList.contains("delBtn")){
		console.log("삭제버튼 클릭");

		let cou_num = e.target.closest('button').value;
		console.log("cou_num =" + cou_num);

		deleteBookmarkFromServer(cou_num).then(result=>{
			if(result > 0){
				alert("댓글 삭제되었습니다");
				getBookmarkList();
			}
		})

	}else if (e.target.tagName === "svg") {
        console.log("삭제버튼 안의 SVG 태그 클릭했음");
    
        // 부모 button 클릭 설정
        let btn = e.target.closest('button');
        if (btn) {
          btn.click();
        }
      }else if(e.target.tagName === "path"){
        console.log("삭제버튼 안의 SVG 태그-path 클릭했음");
    
        let btn = e.target.closest('button');
        if (btn) {
          btn.click();
        }
      }


})
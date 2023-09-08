//댓글등록
async function postCourseToServer(couData){
    try {
        const url = '/cou_comment/post';
        const config = {
            method:"post",
            headers: {
                'content-type':'application/json; charset=utf-8'
            },
            body:JSON.stringify(couData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text(); 
        return result;
    } catch (err) {
        console.log(err);
    }
}

document.getElementById('couPostBtn').addEventListener('click',()=>{
    const couText = document.getElementById('couText').value;
    console.log(couText);
    if(couText == "" || couText == null){
        alert('댓글을 입력해주세요.');
        document.getElementById('couText').focus();
        return false;
    }else{
        let couData = {
            cou_num : cnoVal,
            id : id,
            cou_com_content : couText
        };
        console.log(couData);
        postCourseToServer(couData).then(result=>{
            //isOk 확인 데이터
            if(result > 0){
                alert("댓글 등록 성공~!!");
                couCommentList(couData.cou_num);
            }
        })
    }
})
//한 강의에 대한 댓글 뿌리기(댓글 리스트)
async function spreadCou_CommentFromServer(cou_num){
    console.log(cou_num);
    try {
        const resp = await fetch('/cou_comment/'+cou_num);
        const result = await resp.json();
        return result;
    } catch (err) {
        console.log(err);
    }
}

function couCommentList(cou_num){
    spreadCou_CommentFromServer(cou_num).then(result =>{
        console.log(result);
        const div = document.getElementById('cou_commnetlist');
        if(result.length > 0){
            div.innerHTML = "";
            for(let ccvo of result){
                let d = `<div class="comment_content">`;
                d += `<div><h4 class="nickname">${ccvo.id}</h4></div>`;
                d += `<div data-cou_com_num="${ccvo.cou_com_num}" data-cou_com_content="${ccvo.cou_com_content}">`;
                d += `<input type="text" id="cou_comment" value="${ccvo.cou_com_content}">`;
                console.log(ccvo.cou_com_isMod);
                if(ccvo.cou_com_isMod == 'Y'){
                    d += `  <div>
                                <span>${ccvo.cou_com_reg_date} •</span>
                                <span>수정됨</span>
                             </div> 
                        <button type="button" class="modBtn">✔수정&nbsp;&nbsp;</button>
                        <button type="button" class="delBtn">✂삭제</button> 
                    </div>`;
                }else{
                    d += `<div>
                            <span>${ccvo.cou_com_reg_date} </span>

                          </div> 
                        <button type="button" class="modBtn">✔수정&nbsp;&nbsp;</button>
                        <button type="button" class="delBtn">✂삭제</button> 
                    </div>`;
                }
              
                d += `</div>`;
                d += ` <div class="comment_line"></div>`;
                div.innerHTML += d;
            }
        }
    })
    
}
//댓글 수정
async function editCou_CommentToServer(couDataMod){
    try {
        const url = '/cou_comment/edit';
        const config={
            method:'put',
            headers:{
                'content-type':'application/json; charset=utf-8'
            },
            body:JSON.stringify(couDataMod)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (err) {
        console.log(err);
    }
}
//댓글 삭제
async function removeCou_CommentToServer(cou_com_num){
    try {
        const url = '/cou_comment/'+cou_com_num;
        const config={
            method:'delete',
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (err) {
        console.log(err);
    }
}
//댓글 수정&삭제 버튼
document.addEventListener('click',(e)=>{
    console.log(e.target);
    if(e.target.classList.contains('modBtn')){
        console.log("수정버튼 클릭시");
        //내가 클릭한 버튼의 댓글 뭉치
        let div = e.target.closest('div');
        let ccnoVal = div.dataset.cou_com_num;
        console.log(ccnoVal);
        // let input = e.target.closest('input');
        // console.log(input);
        let textContent = div.querySelector('#cou_comment').value;
        
        //let textContent = "제발";
        console.log(textContent);

        let couDataMod={
            cou_com_num : ccnoVal,
            cou_com_content : textContent
        };
        console.log(couDataMod);
        //서버 연결
        editCou_CommentToServer(couDataMod).then(result=>{
            if(result > 0){
                alert('댓글 수정 성공');
            }
            couCommentList(cnoVal);
        })
    }else if(e.target.classList.contains('delBtn')){
        console.log("삭제버튼 클릭시");
        let div = e.target.closest('div');
        let ccnoVal = div.dataset.cou_com_num;
        console.log(ccnoVal);
        removeCou_CommentToServer(ccnoVal).then(result=>{
            if(result > 0){
                alert('댓글 삭제 완료!');
            }
            couCommentList(cnoVal);
        })
    }

})
//----------------------------------------------------------------------------------------
//북마크
async function bookmarkFromServer(cnoVal){
    try {
        const resp = await fetch("/co/updateBookmark/" + cnoVal);
        const result = await resp.text();
        return result;
    } catch (err) {
        console.log(err);
    }
}

document.getElementById('bookmark').addEventListener('click', ()=>{

        console.log("클릭이되나요?");
        bookmarkFromServer(cnoVal).then(result => {
            if(result > 0){
                console.log("Controller(DB) -> JS : " + (( result > 0 )? "OK":"FAIL"));

                let bkt = document.getElementById('bkt');

                if(bkt.getAttribute("isBookmarked") === "false"){
                    alert("북마크 추가");
                    bkt.innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="white" class="bi bi-bookmark-fill" viewBox="0 0 16 16">
                    <path d="M2 2v13.5a.5.5 0 0 0 .74.439L8 13.069l5.26 2.87A.5.5 0 0 0 14 15.5V2a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2z"/>
                    </svg>`;
                    bkt.setAttribute("isBookmarked", "true");
                    console.log("북마크 추가 넘어가니?");

                }else if(bkt.getAttribute("isBookmarked") === "true"){
                    alert("북마크 취소");
                    console.log("북마크 취소 넘어가니?");
                    bkt.innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="white"  viewBox="0 0 16 16">
                    <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z"/>
                 </svg>`;
                    
                    bkt.setAttribute("isBookmarked","false");
                }
            }
        })

   })

//--------------------------------------------------------------------------------
//e타겟 이용
// document.addEventListener('click', (e) => {
//     if(e.target.classList.contains('bookmarkBtn')){
//         //내가 클릭한 버튼
//         let btn = e.target.contains('div');
//         let btnVal = btn.value;
//         console.log(">>> 클릭한 버튼 value" + btnVal);

//         bookmarkFromServer(cnoVal).then(result => {
//             if(result > 0){
//                 console.log("Controller(DB) -> JS : " + (( result > 0 )? "OK":"FAIL"));

//                 if(btn.getAttribute("isBookmarked") === "false"){
//                     alert("북마크 추가");
//                     btn.innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-bookmark-fill" viewBox="0 0 16 16">
//                     <path d="M2 2v13.5a.5.5 0 0 0 .74.439L8 13.069l5.26 2.87A.5.5 0 0 0 14 15.5V2a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2z"/>
//                         </svg>`;
//                         btn.setAttribute("isBookmark", "true");

//                 }else if(btn.getAttribute("isBookmarked") === "true"){
//                     alert("북마크 취소");
//                     btn.innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="white"  viewBox="0 0 16 16">
//                     <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z"/>
//                         </svg>`;
                    
//                     btn.setAttribute("isBookmark","false");
//                 }
                
//             }
//         })

//     }else if (e.target.tagName === "svg") {
//         console.log("좋아요 버튼 안의 SVG 태그 클릭했음");
    
//         // 부모 button 클릭 설정
//         let btn = e.target.closest('div');
//         if (btn) {
//           btn.click();
//         }
//       }else if(e.target.tagName === "path"){
//         console.log("좋아요 버튼 안의 SVG 태그-path 클릭했음");
    
//         let btn = e.target.closest('div');
//         if (btn) {
//           btn.click();
//         }
//       }
// })

function getBookmarkList(cnoVal){
    bookmarkFromServer(cnoVal).then(result => {
        console.log(result);
        const div = document.getElementById('bookmark');
        if(result.length > 0){
            div.innerHTML="";
            for(let book of result){
                
                            // 빈 북마크
                            let b = `<button class="bookmarkBtn" id="bkt" vlaue="${book.cou_num}" isBookmarked=false>`
                            b += `<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="white"  viewBox="0 0 16 16">
                                    <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z"/>
                                 </svg>`
                            b+=`</button>`
                       
                        
                        div.innerHTML += b;
                    }
                }
                    
            })
        }


// function getBookmarkList(cnoVal){
//     bookmarkFromServer(cnoVal).then(result => {
//         console.log(result);
//         const div = document.getElementById('bookmark');
//         if(result.length > 0){
//             div.innerHTML="";
//             for(let book of result){
                
//                 for(let a of rresult.bookList){

//                     if(cnoVal == a){
//                         //cnoVal이 있으면 북마크 취소 시켜야함 빈 북마크가 나와야 함
                        
//                             let b = `<button class="bookmarkBtn" id="bkt" vlaue="${book.cou_num}" isBookmarked=false>`
//                         b += `<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="white"  viewBox="0 0 16 16">
//                                 <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z"/>
//                             </svg>`
//                         b+=`</button>`
//                         div.innerHTML += b;
                        
//                         }else if(a == false){
//                             // 빈 북마크
//                             let b = `<button class="bookmarkBtn" id="bkt" vlaue="${book.cou_num}" isBookmarked=false>`
//                             b += `<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="white"  viewBox="0 0 16 16">
//                                     <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z"/>
//                                  </svg>`
//                             b+=`</button>`
                       
                        
//                         div.innerHTML += b;
//                     }
//                 }
                    
//             }
//         }
//     })
// }




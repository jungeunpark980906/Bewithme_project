async function spreadCourseFromServer(sub_num){
    console.log(sub_num);
    try{
        const resp = await fetch('/co/'+sub_num);
        const result = await resp.json();
        return result;
    } catch(err){
        console.log(err);
    }
}

function getCourseList(sub_num){
    spreadCourseFromServer(sub_num).then(result => {
        console.log(result);
        const table = document.getElementById('courseListArea');
        let i=0;
        if(result.length > 0){
            table.innerHTML = "";
            for(let cvo of result){
                i++;
                //let t = `<tr><th>${sub_num}-${cvo.cou_num}</th>`;
                let t = `<tr data-cou_num="${cvo.cou_num}" data-sub_num="${sub_num}" ><th>${sub_num}-${i}</th>`;
                t += `<td><a href="/co/link?cou_num=${cvo.cou_num}">${cvo.cou_title}</a></td>`;
                if(sesAdmin == 1){
                    t += `<td class="ck"><a href="/co/mod_link?cou_num=${cvo.cou_num}">✂ 수정</a></td>`;
                    t += `<td class="ck2" id="delBtn">🗑 삭제</td></tr>`;
                }else{
                    t += `<td class="ck2"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
                    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                  </svg></td></tr>`;
                }


                table.innerHTML+=t;
            }
        }
    })
}


async function removeCourseToSever(cou_num){
    try {
        const url = '/co/'+cou_num;
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

document.addEventListener('click',(e)=>{
    console.log(e.target);
    if(e.target.classList.contains('ck2')){
        console.log("삭제버튼 클릭시");
        let tr = e.target.closest('tr');
        let tVal = tr.dataset.cou_num;
        let sub_num = tr.dataset.sub_num;
        console.log(tVal);
        removeCourseToSever(tVal).then(result=>{
            if(result > 0){
                
                getCourseList(sub_num);
            }
        })
    }
})

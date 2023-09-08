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
                t += `<td class="ck" id="modBtn"><a href="">✂ 수정</a></td>`
                t += `<td class="ck2" id="delBtn">
                🗑 삭제
                </td></tr>`;

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
                alert('삭제 완료!');
                getCourseList(sub_num);
            }
        })
    }
})

// document.getElementById('courselistbtn').addEventListener('click',()=>{
//     console.log('a태그 클릭 가능');
//     getCourseList(cou_num);
// })

// function getCourseContent(sub_num){
//     spreadCourseFromServer(sub_num).then(result => {
//         console.log(result);
//         const div = document.getElementById('course2');
//         if(result.length>0){
//             div.innerHTML = "";
//             for(let cno of result){
//                 let h1 = `<h1>${cno.cou_title}</h1>`;
//                 h1 += `<h2>${cno.cou_content}</h2>`;
//                 div.innerHTML+=h1;
//             }
//         }

//     })
// }
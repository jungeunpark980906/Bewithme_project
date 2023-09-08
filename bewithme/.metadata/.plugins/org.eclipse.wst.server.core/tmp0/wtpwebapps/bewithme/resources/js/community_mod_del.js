
//수정
async function updateCommunityFromServer(cmuDataMod){
	try{
		const url = "/community/modify";
		const config={
			method: "put",
			headers: {
				'Content-Type' : 'application/json; charset=utf-8'
			},
			body: JSON.stringify(cmuDataMod)
		}
		const resp = await fetch(url, config);
		const result = await resp.text();  
		return result;
		
	}catch(error){
		console.log(error);
	}
}



document.getElementById('modBtn').addEventListener('click',()=>{

	//썸네일 동기로 보내기
    document.getElementById('subThumbBtn').click();

    const com_title =  document.getElementById('com_title').value;
	const com_content = document.getElementById('summernote').value;
    let com_category = '';
	const categorys = document.getElementsByName('com_category');
	
	categorys.forEach((node) => {
		if(node.checked)  {
			com_category = node.value;
		}
	});
	
	if(com_title == null || com_title == ""){ 
		alert("제목을 입력해주세요");
        document.getElementById('com_title').focus(); 
		return false;

	}else if( com_content == null || com_content == ""){
        alert("내용을 입력해주세요");
        document.getElementById('com_content').focus(); 
		return false;

    }else{
		let cmuDataMod = { 
			com_title : com_title,
            id : document.getElementById("id").value,
            com_category : com_category,
            com_content : com_content,
            com_num : com_num
		};
        console.log(cmuDataMod);

        updateCommunityFromServer(cmuDataMod).then(result=>{
			if(result == 1){
				window.location.href = `/community/detail?com_num=${com_num}`;
			}
		});
    }
});



//-----------------------------------------------------------------------
//삭제
async function deleteCommentFromServer(com_num){
	try {
		const url = "/community/"+ com_num;
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


document.getElementById('delBtn').addEventListener('click',()=>{
    
    deleteCommentFromServer(com_num).then(result=>{
        if(result == 1){
            window.location.href = "/community/communitypage";
        }
    }); 
 
});

//----------------------------------------------------------------------------------------------------

//썸네일 삭제
document.addEventListener('click', (e)=>{
    if(e.target.classList.contains("file-x")){
        console.log("파일삭제 클릭");

        let uuid = e.target.dataset.uuid;
        console.log("삭제 버튼 uuid : " + uuid);

		deleteFileToServer(uuid).then(result=>{
            if(parseInt(result)>0){
                e.target.closest('li').remove();
            }
		})

	}
})

async function deleteFileToServer(uuid){
    try {
        const url = "/community/deleteFile/"+ uuid;
		const config={
			method: "delete"
		};
		const resp = await fetch(url, config); 
		const result = await resp.text(); 
		return result;
    } catch (error) {
        console.log(error);
    }
}

//썸네일 확인
// -- 썸네일 첨부 --
//썸네일 첨부 버튼 클릭시 file버튼 클릭 설정
document.getElementById('trigger').addEventListener('click',()=>{
    document.getElementById('file').click();
})

//파일 첨부가 가능한지 확인하는 함수
const regExp = new RegExp("\.(exe|sh|bat|msi|dll|js)$");  //들어오면 안되는 형식
const regExpImg = new RegExp("\.(jpg|jpeg|png|gif|bmp)$"); //이미지 파일 형식
const maxSize = 1024*1024*20; //20M

function fileSizeValidation(fileName, fileSize){
    if(regExp.test(fileName)){ 
        return 0;
    }else if(fileSize > maxSize){
        return 0;
    }else if(!regExpImg.test(fileName)){
        return 0;
    }else{
        return 1;
    }

}

//파일 첨부시 첨부 가능 여부 확인
document.addEventListener('change',(e)=>{
    console.log("e.target : " + e.target);
    if(e.target.id == 'file'){
        document.getElementById('modBtn').disabled = false;
       
        const fileObject = document.getElementById('file').files;
        console.log("fileObject : " + fileObject);

        //썸네일 첨부가능 유무 출력
        let div = document.getElementById('filezone');
        div.innerHTML=``;
        let ul = `<ul>`;
        let isOk = 1; 
        for(let file of fileObject){
            let vaildResult = fileSizeValidation(file.name, file.size);
            isOk *= vaildResult; //파일의 통과여부(fileSizeValidation) - 통과면 1
            ul+= `<li>`;
            ul+=`${vaildResult ? '<div>썸네일 가능' : '<div>썸네일 불가능'}</div>`;
            ul+=`${file.name} &nbsp;`;
            ul+=`<span class="badge bg-${vaildResult ? 'success' : 'danger'} rounded-pill"> ${file.size}Bytes</span></li>`;
        }
        ul+=`</ul>`;
        div.innerHTML =ul;

        if(isOk == 0){ 
            document.getElementById('modBtn').disabled = true; 
        }
    }
})

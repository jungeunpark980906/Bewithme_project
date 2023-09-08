
async function postCommunityToServer(cmuData){
    try{
        const url = "/community/insert";
		const config = {
			method: 'post',
			headers:{
				'content-Type': 'application/json; charset=utf-8'
			},
			body:JSON.stringify(cmuData)
		};
		const resp = await fetch(url, config); 
		const result = await resp.text(); 
		return result;
		
	}catch(error){
		console.log(">>> 비동기 전송 error발생 : " + error);
	}
}



document.getElementById('subBtn').addEventListener('click',()=>{

    //썸네일 동기로 보내기
    document.getElementById('subThumbBtn').click();

	const com_title =  document.getElementById('com_title').value;
	const com_content = document.getElementById('summernote').value;
	
	//라디오박스 value가져오기
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
		let cmuData = { 
			com_title : com_title,
            id : document.getElementById("id").value,
			nickname : document.getElementById("nickname").value,
            com_category : com_category,
            com_content : com_content
		};
        console.log(cmuData);
        
		postCommunityToServer(cmuData).then(result=>{
			if(result == 1){
				window.location.href = "/community/communitypage";
			}
		});
		
	}

})



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
        document.getElementById('subBtn').disabled = false;
       
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
            document.getElementById('subBtn').disabled = true; 
        }
    }
})
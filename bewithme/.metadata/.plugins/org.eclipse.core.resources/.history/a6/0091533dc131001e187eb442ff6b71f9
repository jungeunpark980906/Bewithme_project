
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
				alert('게시글 수정 완료');
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
            alert('게시글 삭제 완료');
            window.location.href = "/community/communitypage";
        }
    }); 
 
});



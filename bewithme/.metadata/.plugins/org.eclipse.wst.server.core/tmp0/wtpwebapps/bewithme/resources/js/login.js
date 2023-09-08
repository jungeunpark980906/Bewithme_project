async function signIn(userData){
  try{
    const url='/member/login';
    const config={
      method : "post",
      headers : {
        'content-type' : 'application/json; charset=utf-8'
      },
      body:JSON.stringify(userData)
    };
    const resp=await fetch(url, config);
    const result=await resp.text();
    return result;
  }catch(err){
    console.log(err);
  }
}

async function signUp(userData){
  try{
    const url='/member/signup';
    const config={
      method : "post",
      headers : {
        'content-type' : 'application/json; charser=utf-8'
      },
      body:JSON.stringify(userData)
    };
    const resp=await fetch(url, config);
    const result=await resp.text();
    return result;
  }catch(err){
    console.log(err);
  }
}

const signUpBtn = document.getElementById("signUp");
const signInBtn = document.getElementById("signIn");
const container = document.querySelector(".container");

const loginBtn=document.getElementById("loginBtn");
const joinBtn=document.getElementById("joinBtn");

signUpBtn.addEventListener("click", () => {
  container.classList.add("right-panel-active");

});
signInBtn.addEventListener("click", () => {
  container.classList.remove("right-panel-active");
});

loginBtn.addEventListener("click",()=>{
  const signInId=document.getElementById("signInId").value;
  const signInPw=document.getElementById("signInPw").value;

  if(signInId=="" || signInId==null){
    alert("ID를 입력해주세요.");
    document.getElementById('signInId').focus();
    return false;
  }
  else if(signInPw=="" || signInPw==null){
    alert("Password를 입력해주세요.");
    document.getElementById('signInPw').focus();
    return false;
  }
  else{
    let userData={
      id : signInId,
      pw : signInPw
    };
    console.log(userData);
    signIn(userData).then(result=>{
      if(result>0){
        location.href="/main/start";
      }
      else{
        alert("로그인 실패!");
      }
    })
  }

});

joinBtn.addEventListener("click",()=>{
  const signUpId=document.getElementById("signUpId").value;
  const signUpPw=document.getElementById("signUpPw").value;
  const signUpNick=document.getElementById("signUpNick").value;

  if(signUpId=="" || signUpId==null){
    alert("ID를 입력해주세요.");
    document.getElementById('signUpId').focus();
    return false;
  }
  else if(signUpPw=="" || signUpPw==null){
    alert("Password를 입력해주세요.");
    document.getElementById('signUpPw').focus();
    return false;
  }
  else if(signUpNick=="" || signUpNick==null){
    alert("닉네임을 입력해주세요.");
    document.getElementById('signUpNick').focus();
    return false;
  }
  else{
    let userData={
      id : signUpId,
      pw : signUpPw,
      nickname : signUpNick
    };
    console.log(userData);
    signUp(userData).then(result=>{
      if(result>0){
        alert("회원가입 성공!");
        location.href="/";
      }
      else{
        alert("회원가입 실패!");
      }
    })
  }
})
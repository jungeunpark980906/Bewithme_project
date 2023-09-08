//채팅 유저 목록
async function ChatUserList() {
  try {
    const resp = await fetch("/chat/userList");
    const result = await resp.json();
    return result;
  }
  catch (err) {
    console.log(err);
  }
}

//채팅 유저 목록 출력
function printChatUserList() {
  ChatUserList().then(result => {
    console.log("userList length : " + result.length);
    const inbox_chat = document.getElementById('inbox_chat');
    let div = '';
    if (result.length > 0) {
      for (let userList of result) {
        let month = userList.chat_time.substring(userList.chat_time.indexOf("-") + 1, userList.chat_time.lastIndexOf("-"));
        if (month.charAt(0) == '0') {
          month = month.charAt(1);
        }
        let day = userList.chat_time.substring(userList.chat_time.lastIndexOf("-") + 1, userList.chat_time.lastIndexOf("-") + 3);
        if (day.charAt(0) == '0') {
          day = day.charAt(1);
        }
        div += `<div id="chat_list" class="chat_list" data-fromid="${userList.from_id}">
        <div class="chat_people" data-fromid="${userList.from_id}">
          <div class="chat_img" data-fromid="${userList.from_id}"> <img src="https://cdn-icons-png.flaticon.com/256/8955/8955051.png" alt="sunil"> </div>
          <div class="chat_ib" data-fromid="${userList.from_id}">
            <h5 class="chat_h">${userList.from_id}<span class="chat_date">${month}월 ${day}일</span></h5>
            <p>${userList.chat_content}</p>
          </div>
        </div>
      </div>`
      }
    }
    inbox_chat.innerHTML = div;
  })
}

//채팅 유저 목록 선택 시
let fromId = ''; // 채팅을 보낼 대상
document.addEventListener('click', (e) => {
  if (e.target.classList.contains('chat_h')) {
    console.log("채팅 유저 목록 클릭됨.");
    let div = e.target.closest('div');
    fromId = div.dataset.fromid;
    console.log("채팅 목록 클릭 formID : " + fromId);
    getMsgList(fromId);
    scrollBottom();
    //채팅 유저 목록 클릭 시 색 변화 기능 구현...
    // div.classList.add('active_chat');
  }
})

// document.getElementById('chat_list').addEventListener('click',()=>{
//   let fromId=document.getElementById('chat_list').dataset.fromid;
//   console.log("채팅 목록 클릭 formID : "+fromId);
// })

// 채팅 내용 저장
async function registerMsg(msgData) {
  try {
    const url = "/chat/register";
    const config = {
      method: "post",
      headers: {
        "content-type": "application/json; charset=utf-8"
      },
      body: JSON.stringify(msgData)
    };
    const resp = await fetch(url, config);
    const result = await resp.text();
    return result;
  } catch (err) {
    console.log(err);
  }
}

//채팅 리스트 출력
async function printMsgList(userId) {
  try {
    const resp = await fetch("/chat/list/" + userId);
    const result = await resp.json();
    return result;
  }
  catch (err) {
    console.log(err);
  }
}

function scrollBottom() {
  console.log("scrollBottm 실행됨");
  const msg_history = document.querySelector('.msg_history');
  console.log("scrollTop >> " + msg_history.scrollTop);
  console.log("scrollHeight >> " + msg_history.scrollHeight);
  console.log("clientHeight >> " + msg_history.clientHeight);
  msg_history.scrollTop = msg_history.scrollHeight - msg_history.clientHeight;
  console.log("scrollTop >> " + msg_history.scrollTop);
}


//엔터키 입력 시
function enterkey(e) {
  if (e.code == 'Enter') {
    const msg = document.getElementById('write_msg').value;
    if (userId == "" || userId == null) {
      alert("세션이 완료되었습니다. 다시 로그인 해주세요.")
      location.href = "/member/logout";
    }
    else if (msg == "" || msg == null) {
      alert("문의할 내용을 작성해주세요.");
      document.getElementById('write_msg').focus();
      return false;
    }
    else {
      let toId = fromId;

      let msgData = {
        from_id: userId,
        to_id: toId,
        chat_content: msg
      };
      console.log("msgData >> " + msgData);
      registerMsg(msgData).then(result => {
        console.log("msgData result >> " + result);
        if (result > 0) {
          document.getElementById('write_msg').value = null;
          getMsgList(fromId);
        }
        else {
          alert("메세지 전송 실패ㅜ");
          getMsgList(fromId);
        }
      })
    }
  }
}

//전송 버튼 클릭 시 
document.getElementById('msg_send_btn').addEventListener('click', () => {
  const msg = document.getElementById('write_msg').value;
  if (userId == "" || userId == null) {
    alert("세션이 완료되었습니다. 다시 로그인 해주세요.")
    location.href = "/member/logout";
  }
  else if (msg == "" || msg == null) {
    alert("문의할 내용을 작성해주세요.");
    document.getElementById('write_msg').focus();
    return false;
  }
  else {
    let toId = fromId;

    let msgData = {
      from_id: userId,
      to_id: toId,
      chat_content: msg
    };
    console.log("msgData >> " + msgData);
    registerMsg(msgData).then(result => {
      console.log("msgData result >> " + result);
      if (result > 0) {
        document.getElementById('write_msg').value = null;
        getMsgList(fromId);
      }
      else {
        alert("메세지 전송 실패ㅜ");
        getMsgList(fromId);
      }
    })
  }

})

//채팅 리스트 가져오기 및 출력
function getMsgList(userId) {
  printMsgList(userId).then(result => {
    const msg_history = document.getElementById('msg_history');
    msg_history.innerHTML = `<div class="incoming_msg">
    <div class="incoming_msg_img"> <img src="https://cdn-icons-png.flaticon.com/256/8955/8955051.png" alt="sunil">
    </div>
    <div class="received_msg">
      <div class="received_withd_msg">
        <p>안녕하세요. ${userId}님 무엇을 도와드릴까요?</p>
        <span class="time_date"> 11:01 AM | June 9</span>
      </div>
    </div>
  </div>`;
    if (result.length > 0) {
      let div = '';
      for (let ChatVO of result) {
        if (ChatVO.from_id == 'admin') {
          div += `<div class="incoming_msg">
        <div class="incoming_msg_img"> <img src="https://cdn-icons-png.flaticon.com/256/8955/8955051.png" alt="sunil">
        </div>
        <div class="received_msg">
          <div class="received_withd_msg">
            <textarea disabled>${ChatVO.chat_content}</textarea>
            <span class="time_date"> ${ChatVO.chat_time}</span>
          </div>
        </div>
      </div>`;
        } else {
          div += `<div class="outgoing_msg">
      <div class="sent_msg">
        <p>${ChatVO.chat_content}</p>
        <span class="time_date"> ${ChatVO.chat_time}</span>
      </div>
    </div>`
        }
      }
      msg_history.innerHTML += div;
    }
    autosize(document.querySelectorAll('textarea'));
    scrollBottom();
  })
}

//챗봇 추가 모달
const openModalButton = document.getElementById('chatBotAddBtn');
const modalOverlay = document.querySelector('.modal-overlay');
const chatBotRegisterBtn = document.getElementById('chatBotRegisterBtn');

const chat_title = document.getElementById('chat_title');
const chat_content = document.getElementById('chat_content');
const chat_btn = document.getElementById('chat_btn');

modalOverlay.addEventListener('click', function (event) {
  if (event.target === modalOverlay) {
    modalOverlay.style.visibility = 'hidden';
  }
});

//챗봇 내용 저장
async function registerChatBot(chatBotData) {
  try {
    const url = "/chatbot/register";
    const config = {
      method: "post",
      headers: {
        "content-type": "application/json; charset=utf-8"
      },
      body: JSON.stringify(chatBotData)
    };
    const resp = await fetch(url, config);
    const result = await resp.text();
    return result;
  } catch (err) {
    console.log(err);
  }
}

//챗봇 목록 출력
async function getChatBotList() {
  try {
    const resp = await fetch("/chatbot/list");
    const result = await resp.json();
    return result;
  } catch (err) {
    console.log(err);
  }
}

//챗봇 목록 화면에 출력
function printChatBotList() {
  getChatBotList().then(result => {
    let div = `<div class="chat_bot">
    <div class="chat_bot_title">
      <span class="material-symbols-outlined">
        add_circle
        </span>
    </div>
    <div class="chat_bot_btn">
      <button type="button" class="chatBotAddBtn" id="chatBotAddBtn">챗봇 추가</button>
    </div>
  </div>`;
    if (result.length > 0) {
      for (let chatBot of result) {
        div += `<div class="chat_bot">
        <div class="chat_bot_title">
          <h1>${chatBot.title_content}</h1>
        </div>
        <div class="chat_bot_btn" data-content="${chatBot.bot_content}" data-btncontent="${chatBot.btn_content}">
          <button class="bot_btn" id="chat_bot_btn">${chatBot.btn_content}</button>
          </div>
      </div>`
      }
    }
    document.getElementById('chatBotContainer').innerHTML = div;
  })
}

//모달 폼 내 챗봇추가 버튼 클릭 시
document.getElementById('chatBotRegisterBtn').addEventListener('click', () => {
  if (chat_title.value === "" || chat_title.value === null) {
    alert("제목을 입력해주세요.");
    chat_title.focus();
  }
  else if (chat_content.value === "" || chat_content.value === null) {
    alert("내용을 입력해주세요.");
    chat_content.focus();
  }
  else if (chat_btn.value === "" || chat_btn.value === null) {
    alert("버튼 내용을 입력해주세요.");
    chat_btn.focus();
  } else {
    let chatBotData = {
      id: userId,
      title_content: chat_title.value,
      bot_content: chat_content.value,
      btn_content: chat_btn.value
    };
    console.log("chatBotData : " + chatBotData);
    registerChatBot(chatBotData).then(result => {
      console.log("챗봇 저장 : " + result);
      if (result > 0) {
        printChatBotList();
        modalOverlay.style.visibility = 'hidden';
      } else {
        alert("챗봇 내용 추가 실패ㅠ");
        printChatBotList();
      }
    })
  }
})

//챗봇 버튼 클릭 시 내용 출력
let chatbot_content = '';
let chatbot_btn = '';
document.addEventListener('click', (e) => {
  console.log(e.target);
  if (e.target.classList.contains('bot_btn')) {
    console.log('챗봇 버튼 클릭됨!');
    let div = e.target.closest('div');
    chatbot_content = div.dataset.content;
    chatbot_btn = div.dataset.btncontent;
    console.log("챗봇 내용 : " + chatbot_content);
    console.log("챗봇 버튼 내용 : " + chatbot_btn);
    console.log("내가 말한 내용 : " + chatbot_btn);
    console.log("관리자가 말한 내용 : " + chatbot_content);
  }
  if (e.target.classList.contains('chatBotAddBtn')) {
    console.log("챗봇 추가 버튼 클릭.");
    modalOverlay.style.visibility = 'visible';
    chat_title.value = null;
    chat_content.value = null;
    chat_btn.value = null;
  }
})
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
  // msg_history.scrollTop = msg_history.scrollHeight - msg_history.clientHeight;
  msg_history.scrollTop = msg_history.scrollHeight;
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
      let toId = '';
      if (userId != 'admin') {
        toId = 'admin';
      }
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
          getMsgList(userId);
        }
        else {
          alert("메세지 전송 실패ㅜ");
          getMsgList(userId);
        }
      })
    }
  }
}

//채팅 전송 버튼 클릭 시
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
    let toId = '';
    if (userId != 'admin') {
      toId = 'admin';
    }
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
        getMsgList(userId);
      }
      else {
        alert("메세지 전송 실패ㅜ");
        getMsgList(userId);
      }
    })
  }

})

//채팅 리스트 가져오기
function getMsgList(userId) {
  printMsgList(userId).then(result => {
    const msg_history = document.getElementById('msg_history');
    msg_history.innerHTML = `<div class="incoming_msg">
    <div class="incoming_msg_img"> <img src="https://cdn-icons-png.flaticon.com/256/8955/8955051.png" alt="sunil">
    </div>
    <div class="received_msg">
      <div class="received_withd_msg">
        <p>안녕하세요. ${nickname}님 무엇을 도와드릴까요?</p>
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
    if (result.length > 0) {
      let div = '';
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
      document.getElementById('chatBotContainer').innerHTML = div;
    }
  })
}

//챗봇 버튼 클릭 시 내용 출력
let chatbot_content = '';
let chatbot_btn = '';
document.addEventListener('click', (e) => {
  if (e.target.classList.contains('bot_btn')) {
    console.log('챗봇 버튼 클릭됨!');
    let div = e.target.closest('div');
    chatbot_content = div.dataset.content;
    chatbot_btn = div.dataset.btncontent;
    console.log("내가 말한 내용 : " + chatbot_btn);
    console.log("관리자가 말한 내용 : " + chatbot_content);

    if (userId == "" || userId == null) {
      alert("세션이 완료되었습니다. 다시 로그인 해주세요.")
      location.href = "/member/logout";
    } else {
      let toId = '';
      if (userId != 'admin') {
        toId = 'admin';
      }
      //챗봇 유저 멘트 저장
      let msgData_user = {
        from_id: userId,
        to_id: toId,
        chat_content: chatbot_btn
      };
      registerMsg(msgData_user).then(result => {
        if (result > 0) {
          console.log("챗봇 유저 내용 저장 성공!");
          //시간 간격을 두기 위해서 이렇게 함.
          //챗봇 관리자 멘트 저장
          let msgData_admin = {
            from_id: toId,
            to_id: userId,
            chat_content: chatbot_content
          };
          registerMsg(msgData_admin).then(result => {
            if (result > 0) {
              console.log("챗봇 관리자 내용 저장 성공!");
              getMsgList(userId);
            } else {
              alert("챗봇 동작 오류!");
              getMsgList(userId);
            }
          })
        } else {
          alert("챗봇 동작 오류!");
          getMsgList(userId);
        }
      })
    }
  }
})


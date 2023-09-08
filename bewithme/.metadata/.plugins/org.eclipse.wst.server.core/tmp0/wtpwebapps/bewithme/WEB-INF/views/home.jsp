<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
	    <link rel="stylesheet" type="text/css" href="/resources/css/login.css">
</head>
<body>
    <div class="wrapper">
        <div class="container">
          <div class="sign-up-container">
            <form>
              <h1>Create Account</h1>
              <div class="social-links">
                <div>
                  <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                </div>
                <div>
                  <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                </div>
                <div>
                  <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                </div>
              </div>
              <span>or use your email for registration</span>
              <input id="signUpId" type="email" name="id" placeholder="Email">
              <input id="signUpPw" type="password" name="pw" placeholder="Password">
              <input id="signUpNick" type="text" name="nickname" placeholder="NickName">
              <button type="button" id="joinBtn" class="form_btn">Sign Up</button>
            </form>
          </div>
          <div class="sign-in-container">
            <form>
              <h1>Sign In</h1>
              <div class="social-links">
                <div>
                  <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                </div>
                <div>
                  <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                </div>
                <div>
                  <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                </div>
              </div>
              <span>or use your account</span>
              <input id="signInId" type="email" name="id" placeholder="Email">
              <input id="signInPw" type="password" name="pw" placeholder="Password">
              <button type="button" id="loginBtn" class="form_btn">Sign In</button>
            </form>
          </div>
          <div class="overlay-container">
            <div class="overlay-left">
              <h1>Welcome Back</h1>
              <p>To keep connected with us please login with your personal info</p>
              <button id="signIn" class="overlay_btn">Sign In</button>
            </div>
            <div class="overlay-right">
              <h1>Hello, Friend</h1>
              <p>Enter your personal details and start journey with us</p>
              <button id="signUp" class="overlay_btn">Sign Up</button>
            </div>
          </div>
        </div>
      </div>
      <script src="/resources/js/login.js"></script>
</body>
</html>

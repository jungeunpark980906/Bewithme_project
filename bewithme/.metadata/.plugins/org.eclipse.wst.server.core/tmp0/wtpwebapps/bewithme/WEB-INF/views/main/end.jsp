<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body{
            background-color: #030201;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        
    </style>
</head>
<body>
    <img alt="인사gif" src="/resources/img/ending.gif">

<script type="text/javascript">
	setTimeout(() => {
		window.location.href="/member/logout";
	}, 2000);
</script>
</body>
</html>
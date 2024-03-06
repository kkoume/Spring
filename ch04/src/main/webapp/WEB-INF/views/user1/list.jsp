<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>user1::list</title>
</head>
<body>
    <h3>user1 목록</h3>

    <a href="/ch04">메인</a>
    <a href="/ch04/user1/register">등록</a>

    <table border="1">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>생년월일</th>
            <th>휴대폰</th>
            <th>나이</th>
            <th>관리</th>
        </tr>

        <c:forEach var="user" items="${users}">
            <tr>
                <th>${user.uid}</th>
                <th>${user.name}</th>
                <th>${user.birth}</th>
                <th>${user.hp}</th>
                <th>${user.age}</th>
                <th>
                    <a href="/ch04/user1/modify?uid=${user.uid}">수정</a>
                    <a href="/ch04/user1/delete?uid=${user.uid}">삭제</a>
                </th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

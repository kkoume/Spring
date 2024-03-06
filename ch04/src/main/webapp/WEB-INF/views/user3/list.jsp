<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>user3::list</title>
</head>
<body>
    <h3>user3 목록</h3>

    <a href="/ch04">메인</a>
    <a href="/ch04/user3/register">등록</a>

    <table border="1">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>생년월일</th>
            <th>휴대폰</th>
            <th>주소</th>
            <th>관리</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <th>${user.uid}</th>
                <th>${user.name}</th>
                <th>${user.birth}</th>
                <th>${user.hp}</th>
                <th>${user.addr}</th>
                <th>
                    <a href="/ch04/user3/modify?uid=${user.uid}">수정</a>
                    <a href="/ch04/user3/delete?uid=${user.uid}">삭제</a>
                </th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

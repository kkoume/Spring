<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>user5::modify</title>
</head>
<body>
    <h3>user5 수정</h3>
    <a href="/ch05">메인</a>
    <a href="/ch05/user5/list">목록</a>
    <form action="/ch05/user5/modify" method="post">
        <input type="hidden" name="seq" value="${user5DTO.seq}">
        <table border="1">
            <tr>
                <td>이름</td>
                <td><input type="text" name="name" value="${user5DTO.name}"></td>
            </tr>
            <tr>
                <td>성별</td>
                <td><input type="text" name="gender" value="${user5DTO.gender}"></td>
            </tr>
            <tr>
                <td>나이</td>
                <td><input type="number" name="age" value="${user5DTO.age}"></td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input type="text" name="addr" value="${user5DTO.addr}"></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><input type="submit" value="수정"></td>
            </tr>
        </table>
    </form>
</body>
</html>
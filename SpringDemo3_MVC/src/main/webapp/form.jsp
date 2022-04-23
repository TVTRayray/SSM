<html>
<body>
<h2>Title</h2>
    <form action="${pageContext.request.contextPath}/user1/quick4" method="post">
        <%--表明第一个User对象的username add--%>
        <input type="text" name="userList[0].name"><br/>
        <input type="text" name="userList[0].add"><br/>
        <input type="text" name="userList[1].name"><br/>
        <input type="text" name="userList[1].add"><br/>
        <input type="submit">
    </form>
</body>
</html>

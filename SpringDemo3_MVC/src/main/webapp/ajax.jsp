<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-3.3.1.js"></script>
    <script>
        var userList = new Array();
        userList.push({name:"Ray",add:"sc"});
        userList.push({name:"Ray",add:"sc"});

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user1/quick5",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>

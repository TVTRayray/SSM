<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    单文件上传
    <form action="${pageContext.request.contextPath}/user2/quick1" method="post" enctype="multipart/form-data">
        名称<input type="text" name="username"><br/>
        文件<input type="file" name="uploadFile"><br/>
        <input type="submit" value="提交">
    </form>

    多文件上传
        将name统一命名为“uploadFile”，会传入数组形式的参数，采用循环的方式进行存储
    <form action="${pageContext.request.contextPath}/user2/quick2" method="post" enctype="multipart/form-data">
        名称<input type="text" name="username"><br/>
        文件1<input type="file" name="uploadFile"><br/>
        文件2<input type="file" name="uploadFile"><br/>
        文件3<input type="file" name="uploadFile"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>

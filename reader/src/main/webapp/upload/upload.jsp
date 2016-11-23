<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/22
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/book/importBookFile.json" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/> <input type="submit" value="Submit"/></form>
</body>
</html>

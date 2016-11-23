<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/reader/book/importBookFile.json" method="post" enctype="multipart/form-data">
    <input type="file" name="logoFile"/>
    <input type="file" name="bookFile"/>
    <input type="text" name="bookname"/>
    <input type="submit" value="Submit"/></form>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find room by name containing</title>
</head>
<body>
<h2>Find room by name containing</h2>
<form:form action="/room/find-by-room-name" method="POST" modelAttribute="filterForm">
    Last name: <form:input path="roomName"/><br/>
    <input type="submit" value="Find all!"/>
</form:form>
</body>
</html>
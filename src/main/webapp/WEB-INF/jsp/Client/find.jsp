<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find clients by last name containing</title>
</head>
<body>
<h2>Find clients by last name containing</h2>
<form:form action="/client/find-by-last-name" method="POST" modelAttribute="filterForm">
    Last name: <form:input path="lastName"/><br/>
    <input type="submit" value="Find all!"/>
</form:form>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create event</title>
</head>
<body>
<h2>Create event form</h2>
<form:form action="/event/create/${clientId}" method="POST" modelAttribute="event">
    Name: <form:input path="name"/> <br />
    Date: <form:input path="date"/> <br />
    Is free entry: <form:input path="isFreeEnter"/> <br />
    How long: <form:input path="howManyHours"/> <br />
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>
<%--private String name;--%>
<%--private LocalDate date;--%>
<%--private Boolean isFreeEnter;--%>
<%--private Integer howManyHours;--%>

<%--Name: ${event.name}<br />--%>
<%--Date: ${event.date}<br />--%>
<%--Is free entry: ${event.isFreeEnter}<br />--%>
<%--How long: ${event.howManyHours}<br />--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit event</title>
</head>
<body>
<h2>Edit event form</h2>
<form:form action="/event/edit/${event.id}" method="POST" modelAttribute="event">
    Event name: <form:input path="name"/><br/>
    Date: <form:input path="date"/><br/>
    Is free entry: <form:input path="isFreeEnter"/><br/>
    How long: <form:input path="howManyHours"/><br/>
    <form:hidden path="id" />
    <input type="submit" value="Save"/>
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
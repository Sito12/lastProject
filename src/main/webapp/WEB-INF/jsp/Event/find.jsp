<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Find events by name containing</title>
</head>
<body>
<h2>Find events by name containing</h2>
<form:form action="/event/find-by-name" method="POST" modelAttribute="filterForm">
    Event name: <form:input path="name"/><br/>
    Date: <form:input path="date"/><br/>
    Is free entry: <form:input path="isFreeEnter"/><br/>
    How long: <form:input path="howManyHours"/><br/>
    <input type="submit" value="Find all!"/>
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
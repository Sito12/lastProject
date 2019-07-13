<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Events</title>
</head>
<body>
<h2>Events</h2>


<c:if test="${empty events}">
    <h3>Sorry, no records found... :(</h3>
</c:if>



<c:forEach items="${event}" var="event">
    Event name: ${event.roomName} <br/>
    Date: ${event.date} <br/>
    Is free entry: ${event.isFreeEnter} <br/>
    How long: ${event.howManyHours} <br/>

    Client first name: ${event.client.firstName} <br/>
    Client last name: ${event.client.lastName} <br/>
    Room name: ${event.room.roomName} <br/>
    <a href="/event/edit/${event.id}">Edit</a>
    <br/><br/><br/>
</c:forEach>
</body>
</html>
<%--private String name;--%>
<%--private LocalDate date;--%>
<%--private Boolean isFreeEnter;--%>
<%--private Integer howManyHours;--%>
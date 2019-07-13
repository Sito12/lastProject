<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Rooms</title>
</head>
<body>
<h2>Rooms</h2>


<c:if test="${empty rooms}">
    <h3>Sorry, no records found... :(</h3>
</c:if>



<c:forEach items="${room}" var="room">
    Room name: ${room.roomName} <br/>
    Has a projector: ${room.isThereProjector} <br/>
    Has a stage: ${room.isThereStage} <br/>
    Has a audio equipment: ${room.isThereAudio} <br/>
    Price per hour: ${room.price} <br/>
    Event name: ${room.event.name} <br/>
    Event date: ${room.event.date} <br/>
    Client first name: ${room.client.firstName} <br/>
    Client last name: ${room.client.lastName} <br/>
    <a href="/room/edit/${room.id}">Edit</a>
    <br/><br/><br/>
</c:forEach>
</body>
</html>

<%--private String roomName;--%>
<%--private Boolean isThereProjector;--%>
<%--private Boolean isThereStage;--%>
<%--private Boolean isThereAudio;--%>
<%--private Integer price;--%>

<%--Room name: <form:input path="roomName"/> <br />--%>
<%--Has a projector: <form:input path="isThereProjector"/> <br />--%>
<%--Has a stage: <form:input path="isThereStage"/> <br />--%>
<%--Has a audio equipment: <form:input path="isThereAudio"/> <br />--%>
<%--Price per hour: <form:input path="price"/> <br />--%>

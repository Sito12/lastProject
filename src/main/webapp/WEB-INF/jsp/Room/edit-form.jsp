<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit room</title>
</head>
<body>
<h2>Edit room form</h2>
<form:form action="/room/create/${room.id}" method="POST" modelAttribute="room">
    Room name: <form:input path="roomName"/> <br />
    Has a projector: <form:input path="isThereProjector"/> <br />
    Has a stage: <form:input path="isThereStage"/> <br />
    Has a audio equipment: <form:input path="isThereAudio"/> <br />
    Price per hour: <form:input path="price"/> <br />

    <form:hidden path="id" />
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>

<%--private String roomName;--%>
<%--private Boolean isThereProjector;--%>
<%--private Boolean isThereStage;--%>
<%--private Boolean isThereAudio;--%>
<%--private Integer price;--%>

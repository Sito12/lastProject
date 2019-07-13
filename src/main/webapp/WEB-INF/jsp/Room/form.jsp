<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create room</title>
</head>
<body>
<h2>Create room form</h2>
<form:form action="/room/create/${roomId}" method="POST" modelAttribute="room">
    Room name: <form:input path="roomName"/> <br />
    Has a projector: <form:input path="isThereProjector"/> <br />
    Has a stage: <form:input path="isThereStage"/> <br />
    Has a audio equipment: <form:input path="isThereAudio"/> <br />
    Price per hour: <form:input path="price"/> <br />
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>

<%--private String roomName;--%>
<%--private Boolean isThereProjector;--%>
<%--private Boolean isThereStage;--%>
<%--private Boolean isThereAudio;--%>
<%--private Integer price;--%>

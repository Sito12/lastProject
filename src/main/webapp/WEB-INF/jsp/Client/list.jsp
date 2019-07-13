<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clients</title>
</head>
<body>
<h2>Clients</h2>


<c:if test="${empty clients}">
    <h3>Sorry, no records found... :(</h3>
</c:if>



<c:forEach items="${clients}" var="client">
    First name: ${client.firstName} <br/>
    Last name: ${client.lastName} <br/>
    Is company: ${client.isCompany} <br/>
    Company name: ${client.companyName} <br/>
    Email: ${client.email} <br/>
    Telephone: ${client.telephone} <br/>
    <a href="/client/edit/${client.id}">Edit</a>
    <a href="/client/delete/${client.id}">Delete</a>
    <a href="/event/create/${client.id}">Add event</a>
    <br /><br />
    <c:forEach items="${client.events}" var="event">
        Name: ${event.name}<br />
        Date: ${event.date}<br />
        Is free entry: ${event.isFreeEnter}<br />
        How long: ${event.howManyHours}<br />

        <a href="/visit/create/${event.id}">Add visit</a> <br /><br />
        <br /><br />
    </c:forEach>
    <br/><br/><br/><br />
</c:forEach>
</body>
</html>

<%--private String firstName;--%>
<%--private String lastName;--%>
<%--private boolean isCompany;--%>
<%--private String companyName;--%>
<%--private String email;--%>
<%--private String telephone;--%>

<%--private String name;--%>
<%--private LocalDate date;--%>
<%--private Boolean isFreeEnter;--%>
<%--private Integer howManyHours;--%>
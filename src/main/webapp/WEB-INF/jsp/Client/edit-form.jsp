<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit client</title>
</head>
<body>
<h2>Edit client form</h2>
<form:form action="/client/edit/${client.id}" method="POST" modelAttribute="client">
    First name: <form:input path="firstName"/> <br />
    Last name: <form:input path="lastName"/> <br />
    Company: <form:input path="isCompany"/> <br />
    Company name: <form:input path="companyName"/> <br />
    Email: <form:input path="email"/> <br />
    Telephone: <form:input path="telephone"/> <br />
    <form:hidden path="id" />
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
<%--private String firstName;--%>
<%--private String lastName;--%>
<%--private boolean isCompany;--%>
<%--private String companyName;--%>
<%--private String email;--%>
<%--private String telephone;--%>

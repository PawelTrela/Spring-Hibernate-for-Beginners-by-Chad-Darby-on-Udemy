
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
First name: <form:input path="firstName"/>
<br><br>
Last name: <form:input path="lastName"/>
<br><br>
Country: <form:select path="country">
<form:option value="POL" label="Poland"/>
<form:option value="GER" label="Germany"/>
<form:option value="FRA" label="France"/>
<form:option value="UKR" label="Ukraine"/>
<form:option value="CZE" label="Czechia"/>
</form:select>
<br><br>
<input type="submit" value="Prześlij"/>
</form:form>
</body>
</html>
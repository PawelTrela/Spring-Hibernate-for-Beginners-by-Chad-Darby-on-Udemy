
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
<form:options items="${theCountryOptions}"/>
</form:select>
<br><br>
Favorite programming language:
Java<form:radiobutton path="favoriteLanguage" value="Java"/>
C#<form:radiobutton path="favoriteLanguage" value="C#"/>
PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
<br><br>
Operating systems:
MS Windows<form:checkbox path="operatingSystems" value="MS Windows"/>
Mac OS<form:checkbox path="operatingSystems" value="Mac OS"/>
Linux<form:checkbox path="operatingSystems" value="Linux"/>
<br><br>
<input type="submit" value="Prześlij"/>
</form:form>
</body>
</html>
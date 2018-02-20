<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student confirmation</title>
</head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName}
<br>
Country: ${student.country}
<br>
Favorite language: ${student.favoriteLanguage}
<ul>
<c:forEach var="tmp" items="${student.operatingSystems}">
<li>${tmp}</li>
</c:forEach>
</ul>
<br>

</body>
</html>
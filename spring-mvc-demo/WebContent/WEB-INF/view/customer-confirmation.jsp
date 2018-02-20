<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Customer Confirmation page</title>
</head>
<body>
The customer is confirmed: ${customer.firstName} ${customer.lastName}
<br>
Free passes: ${customer.freePasses}
<br>
Postal code: ${customer.postalCode}
<br>
Course code: ${customer.courseCode}
</body>
</html>
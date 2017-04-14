<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
<body>
<div class="generic-container">

    <div class="alert alert-success lead">
        ${success}
    </div>

    <span class="well floatRight">
            Go to <a href="<c:url value='/admin/myprofile' />">Edit Profile</a>
        </span>
</div>
</body>

</html>
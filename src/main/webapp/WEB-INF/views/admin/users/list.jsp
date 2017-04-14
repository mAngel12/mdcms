<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Users </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
                <th>ID/Login</th>
                <th width="100"></th>
                <th width="100"></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.ssoId}</td>
                    <td><a href="<c:url value='/admin/users/edit-${user.ssoId}' />" class="btn btn-success custom-width">edit</a></td>
                    <td><a href="<c:url value='/admin/users/delete-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="well">
        <a href="<c:url value='/admin/users/new' />">Add New User</a>
    </div>
</div>
</body>
</html>
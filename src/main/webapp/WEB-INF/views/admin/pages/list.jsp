<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Pages</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Address ID</th>
                <th>Page Title</th>
                <th width="100"></th>
                <th width="100"></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pages}" var="page">
                <tr>
                    <td>${page.addressId}</td>
                    <td>${page.title}</td>
                    <td><a href="<c:url value='/admin/pages/edit-${page.addressId}' />" class="btn btn-success custom-width">edit</a></td>
                    <td><a href="<c:url value='/admin/pages/delete-${page.addressId}' />" class="btn btn-danger custom-width">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="well">
        <a href="<c:url value='/admin/pages/new' />">Add New Page</a>
    </div>
</div>
</body>
</html>
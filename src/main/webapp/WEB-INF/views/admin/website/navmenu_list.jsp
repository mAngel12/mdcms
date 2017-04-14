<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Navigation Menu Links</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Link Title</th>
                <th>Link URL</th>
                <th>Order</th>
                <th width="100"></th>
                <th width="100"></th>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td><span class="glyphicon glyphicon-home"></span> Home</td>
                <td>home</td>
                <td>0</td>
                <td><a class="btn btn-success custom-width disabled">edit</a></td>
                <td><a class="btn btn-danger custom-width disabled">delete</a></td>
            </tr>
            <c:forEach items="${navigationMenuLinks}" var="navigationMenu">
                <tr>
                    <td>${navigationMenu.title}</td>
                    <td>${navigationMenu.url}</td>
                    <td>${navigationMenu.order}</td>
                    <td><a href="<c:url value='/admin/website/editnavmenu-${navigationMenu.id}' />" class="btn btn-success custom-width">edit</a></td>
                    <td><a href="<c:url value='/admin/website/deletenavmenu-${navigationMenu.id}' />" class="btn btn-danger custom-width">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="well">
        <a href="<c:url value='/admin/website/newnavmenu' />">Add New Link to Navigation Menu</a>
    </div>
</div>
</body>
</html>
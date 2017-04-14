<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Images</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Image Title</th>
                <th>Date</th>
                <th>Image Address</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${gallery}" var="image">
                <tr>
                    <td>${image.title}</td>
                    <td>${image.date}</td>
                    <td><a href="${image.address}" class="btn btn-info custom-width" >Open Image</a><br/><h6>${image.address}</h6></td>
                    <td><a href="<c:url value='/admin/gallery/edit-${image.id}' />" class="btn btn-success custom-width">edit</a></td>
                    <td><a href="<c:url value='/admin/gallery/delete-${image.id}' />" class="btn btn-danger custom-width">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="well">
        <a href="<c:url value='/admin/gallery/new' />">Add New Image</a>
    </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Posts </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Title</th>
                <th>Date</th>
                <th>Category</th>
                <th width="100"></th>
                <th width="100"></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>${post.title}</td>
                    <td>${post.date}</td>
                    <td>${post.category.categoryName}</td>
                    <td><a href="<c:url value='/admin/posts/edit-${post.id}' />" class="btn btn-success custom-width">edit</a></td>
                    <td><a href="<c:url value='/admin/posts/delete-${post.id}' />" class="btn btn-danger custom-width">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="well">
        <a href="<c:url value='/admin/posts/new' />">Add New Post</a>
    </div>
</div>
</body>
</html>
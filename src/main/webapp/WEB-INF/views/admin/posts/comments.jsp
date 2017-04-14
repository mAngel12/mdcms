<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Comments</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Comment Date</th>
                <th>Comment Author</th>
                <th>Comment Content</th>
                <th>Post Title</th>
                <th width="100"></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${comments}" var="comment">
                <tr>
                    <td>${comment.date}</td>
                    <td><spring:escapeBody htmlEscape="true" >${comment.author}</spring:escapeBody></td>
                    <td><spring:escapeBody htmlEscape="true" >${comment.content}</spring:escapeBody></td>
                    <td>${comment.post.title}</td>
                    <td><a href="<c:url value='/admin/posts/deletecomment-${comment.id}' />" class="btn btn-danger custom-width">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
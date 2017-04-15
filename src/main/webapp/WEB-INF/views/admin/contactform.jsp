<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Not Readed Contact Messages</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Author</th>
                <th>Date</th>
                <th>Email</th>
                <th>Content</th>
                <th width="100"></th>
                <th width="100"></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${notReadedMsg}" var="nrmsg">
                <tr>
                    <td><spring:escapeBody htmlEscape="true" >${nrmsg.author}</spring:escapeBody></td>
                    <td>${nrmsg.date}</td>
                    <td><spring:escapeBody htmlEscape="true" >${nrmsg.email}</spring:escapeBody></td>
                    <td><spring:escapeBody htmlEscape="true" >${nrmsg.content}</spring:escapeBody></td>
                    <td><a href="<c:url value='/admin/contactform_readedmsg-${nrmsg.id}' />" class="btn btn-info custom-width">readed</a></td>
                    <td><a href="<c:url value='/admin/contactform_deletemsg-${nrmsg.id}' />" class="btn btn-danger custom-width">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Readed Contact Messages</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Author</th>
                <th>Date</th>
                <th>Email</th>
                <th>Content</th>
                <th width="100"></th>
                <th width="100"></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${readedMsg}" var="rmsg">
                <tr>
                    <td><spring:escapeBody htmlEscape="true" >${rmsg.author}</spring:escapeBody></td>
                    <td>${rmsg.date}</td>
                    <td><spring:escapeBody htmlEscape="true" >${rmsg.email}</spring:escapeBody></td>
                    <td><spring:escapeBody htmlEscape="true" >${rmsg.content}</spring:escapeBody></td>
                    <td><a href="<c:url value='/admin/contactform_notreadedmsg-${rmsg.id}' />" class="btn btn-info custom-width">not readed</a></td>
                    <td><a href="<c:url value='/admin/contactform_deletemsg-${rmsg.id}' />" class="btn btn-danger custom-width">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </div>
</div>
</body>
</html>
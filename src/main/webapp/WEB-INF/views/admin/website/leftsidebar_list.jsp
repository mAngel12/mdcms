<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">List of Left Sidebar Panels</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Panel Title</th>
                <th>Order</th>
                <th width="100"></th>
                <th width="100"></th>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Categories</td>
                <td>0</td>
                <td><a class="btn btn-success custom-width disabled">edit</a></td>
                <td><a class="btn btn-danger custom-width disabled">delete</a></td>
            </tr>
            <c:forEach items="${leftSidebarPanels}" var="leftSidebar">
                <tr>
                    <td>${leftSidebar.title}</td>
                    <td>${leftSidebar.order}</td>
                    <td><a href="<c:url value='/admin/website/editleftsidebar-${leftSidebar.id}' />" class="btn btn-success custom-width">edit</a></td>
                    <td><a href="<c:url value='/admin/website/deleteleftsidebar-${leftSidebar.id}' />" class="btn btn-danger custom-width">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="well">
        <a href="<c:url value='/admin/website/newleftsidebar' />">Add New Panel to Left Slider</a>
    </div>
</div>
</body>
</html>
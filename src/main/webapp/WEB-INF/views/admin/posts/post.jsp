<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<body>
<div class="generic-container">
    <div class="well lead">
        <c:choose>
            <c:when test="${edit}">
                Edit Post Form
            </c:when>
            <c:otherwise>
                Add New Post Form
            </c:otherwise>
        </c:choose>
    </div>
    <form:form method="POST" modelAttribute="post" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="title">Title</label>
                <div class="col-md-7">
                    <form:input type="text" path="title" id="title" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="title" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        <c:set var="date" value="<%=new java.util.Date()%>" />
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="date">Date</label>
                <div class="col-md-7">
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="date" path="date" id="date" class="form-control input-sm"/>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatDate pattern="yyyy-MM-dd" type="date" value="${date}" var="nowdate"/>
                            <form:input value="${nowdate}" type="date" path="date" id="date" class="form-control input-sm" />
                        </c:otherwise>
                    </c:choose>
                    <div class="has-error">
                        <form:errors path="date" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="content">Text</label>
                <div class="col-md-7">
                    <form:textarea rows="12" path="content" id="content" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="content" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="category" >Category</label>
                <div class="col-md-7">
                    <form:select path="category.categoryId" items="${categories}" multiple="false" itemValue="categoryId" itemLabel="categoryName" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="category.categoryId" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="well">
            <div class="row">
                <div class="form-actions floatRight">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/admin/posts/posts' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Add Post" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/admin/posts/posts' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
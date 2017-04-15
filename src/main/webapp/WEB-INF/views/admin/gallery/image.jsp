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
                Edit Page Form
            </c:when>
            <c:otherwise>
                Add Page Form
            </c:otherwise>
        </c:choose>
    </div>

    <form:form method="POST" modelAttribute="gallery" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="title">Image Title</label>
                <div class="col-md-7">
                    <form:input type="text" path="title" id="title" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="title" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="address">Image Address</label>
                <div class="col-md-7">
                    <form:input type="text" path="address" id="address" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="address" class="help-inline"/>
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

        <div class="well">
            <div class="row">
                <div class="form-actions floatRight">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/admin/gallery/list' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Add Image" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/admin/gallery/list' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
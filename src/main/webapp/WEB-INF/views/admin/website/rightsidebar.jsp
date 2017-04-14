<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>

<body>
<div class="generic-container">
    <div class="well lead">
        <c:choose>
            <c:when test="${edit}">
                Edit Right Sidebar Panel Form
            </c:when>
            <c:otherwise>
                Add Right Sidebar Panel Form
            </c:otherwise>
        </c:choose>
    </div>
    <form:form method="POST" modelAttribute="rightSidebar" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="title">Panel Title</label>
                <div class="col-md-7">
                    <form:input type="text" path="title" id="title" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="title" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="content">Content</label>
                <div class="col-md-7">
                    <form:textarea rows="5" path="content" id="content" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="content" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="order">Order</label>
                <div class="col-md-7">
                    <form:input type="number" min="1" path="order" id="order" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="order" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="well">
            <div class="row">
                <div class="form-actions floatRight">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/admin/website/rightsidebar_list' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Add Right Slider Panel" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/admin/website/rightsidebar_list' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
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
                Edit Category Form
            </c:when>
            <c:otherwise>
                Add Category Form
            </c:otherwise>
        </c:choose>
    </div>
    <form:form method="POST" modelAttribute="postCategory" class="form-horizontal">
        <form:input type="hidden" path="categoryId" id="categoryId"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="categoryName">Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="categoryName" id="categoryName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="categoryName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="well">
            <div class="row">
                <div class="form-actions floatRight">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/admin/posts/categories' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Add Category" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/admin/posts/categories' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
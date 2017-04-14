<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="col-sm-8 text-left">
    <br>
        <h2>${post.title}</h2>
        <h5><span class="glyphicon glyphicon-time"></span> Published on ${post.date} in the category "<a href="<c:url value='/postcategory-${post.category.categoryId}' />" >${post.category.categoryName}</a>"</h5>
        <p>${post.content}</p>
    <hr>
    <br>
    <h4><span class="glyphicon glyphicon-comment"></span> Leave a Comment:</h4><br/>

    <form:form method="POST" modelAttribute="postComment" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <c:set var="ndate" value="<%=new java.util.Date()%>" />
        <fmt:formatDate pattern="yyyy-MM-dd" type="date" value="${ndate}" var="nowdate"/>
        <form:input type="hidden" id="date" path="date" value="${nowdate}" />

        <form:input type="hidden" id="post" path="post.id" value="${post.id}" />

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="author">Your Name: </label>
                <div class="col-md-7">
                    <form:input type="text" path="author" id="author" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="author" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="content">Your Comment: </label>
                <div class="col-md-7">
                    <form:textarea rows="12" path="content" id="content" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="content" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-actions floatRight">
            <input type="submit" value="Add Comment" class="btn btn-success"/>
        </div>
    </form:form>
    <br><br>

    <p><span class="badge">${numberOfComments}</span> Comments:</p><br>

    <div class="row">
        <c:forEach items="${comments}" var="comment">
            <div class="col-sm-12">
                <h4><span class="glyphicon glyphicon-hand-right" ></span> <spring:escapeBody htmlEscape="true" >${comment.author}</spring:escapeBody> <small> ${comment.date}</small></h4>
            <p>
                <spring:escapeBody htmlEscape="true" >
                    ${comment.content}
                </spring:escapeBody>
            </p>
            <br>
        </div>
        </c:forEach>
    </div>
</div>
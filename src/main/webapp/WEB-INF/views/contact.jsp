<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="col-sm-8 text-left">
    <br>
    <h2>Contact Form</h2>
    <hr>

    <c:if test="${param.success != null}">
        <div class="alert alert-success">
            <p>Sending a message successfully. Please wait for the return mail.</p>
        </div>
    </c:if>

    <form:form method="POST" modelAttribute="contact" class="form-horizontal">
        <form:input type="hidden" id="id" path="id" />
        <c:set var="ndate" value="<%=new java.util.Date()%>" />
        <fmt:formatDate pattern="yyyy-MM-dd" type="date" value="${ndate}" var="nowdate"/>
        <form:input type="hidden" id="date" path="date" value="${nowdate}" />
        <form:input type="hidden" path="readed" id="readed" value="0" />
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
                <label class="col-md-3 control-lable" for="email">Your Email: </label>
                <div class="col-md-7">
                    <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="content">Message Content: </label>
                <div class="col-md-7">
                    <form:textarea rows="12" path="content" id="content" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="content" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="form-actions floatRight">
            <input type="submit" value="Send Message" class="btn btn-success"/>
        </div>
    </form:form>
    <br>

</div>
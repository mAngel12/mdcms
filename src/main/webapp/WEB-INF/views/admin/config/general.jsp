<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
<body>
<div class="generic-container">
    <div class="well lead">
        General Configuration
    </div>
    <form:form method="POST" modelAttribute="generalConfiguration" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="title">Website Title</label>
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
                <label class="col-md-3 control-lable" for="description">Website Description</label>
                <div class="col-md-7">
                    <form:input type="text" path="description" id="description" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="description" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="keywords">Website Keywords</label>
                <div class="col-md-7">
                    <form:input type="text" path="keywords" id="keywords" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="keywords" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="language">Website Abbreviation of Language</label>
                <div class="col-md-7">
                    <form:input type="text" path="language" id="language" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="language" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="footer">Footer Text</label>
                <div class="col-md-7">
                    <form:input type="text" path="footer" id="footer" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="footer" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="author">Website Author Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="author" id="author" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="author" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="well">
            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="Save Settings" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/admin/config/general' />">Cancel</a>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
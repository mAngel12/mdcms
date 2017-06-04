<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
<body>
<div class="generic-container">
    <div class="well lead">
        Other Settings
    </div>
    <form:form method="POST" modelAttribute="settings" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="postsInHomepage">Posts in HomePage</label>
                <div class="col-md-7">
                    <form:input min="1" max="25" type="number" path="postsInHomepage" id="postsInHomepage" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="postsInHomepage" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="commentingOnPosts">Commenting on Posts</label>
                <div class="col-md-7">
                    <form:checkbox path="commentingOnPosts" id="commentingOnPosts"/>
                    <div class="has-error">
                        <form:errors path="commentingOnPosts" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="last5postsOnRightSidebar">Last5Posts Panel on Right Sidebar</label>
                <div class="col-md-7">
                    <form:checkbox path="last5postsOnRightSidebar" id="last5postsOnRightSidebar"/>
                    <div class="has-error">
                        <form:errors path="last5postsOnRightSidebar" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="categoriesOnLeftSidebar">Categories Panel on Left Sidebar</label>
                <div class="col-md-7">
                    <form:checkbox path="categoriesOnLeftSidebar" id="categoriesOnLeftSidebar"/>
                    <div class="has-error">
                        <form:errors path="categoriesOnLeftSidebar" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="linkToAdminPanelInMenu">Show link to AdminPanel in Menu?</label>
                <div class="col-md-7">
                    <form:checkbox path="linkToAdminPanelInMenu" id="linkToAdminPanelInMenu"/>
                    <div class="has-error">
                        <form:errors path="linkToAdminPanelInMenu" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="tinyMCECloudAPIKey">TinyMCE Cloud API Key</label>
                <div class="col-md-7">
                    <form:input type="text" path="tinyMCECloudAPIKey" id="tinyMCECloudAPIKey" class="form-control input-sm"/>
                    <p style="font-size: 8pt; color: grey">To off information: "The API key you have entered is invalid. Please review your API key here" in textareas you should <a href="https://www.ephox.com/?add-to-cart=2881" >get a free API Key</a>.</p>
                    <div class="has-error">
                        <form:errors path="tinyMCECloudAPIKey" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="well">
            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="Save Settings" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/admin/config/other' />">Cancel</a>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
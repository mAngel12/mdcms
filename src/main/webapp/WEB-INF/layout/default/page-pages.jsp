<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>

<html>
<head>
    <title> ${page.title} - ${generalConfig.title} </title>
    <meta name="Description" content="${generalConfig.description}" />
    <meta name="Keywords" content="${generalConfig.keywords}" />
    <meta http-equiv="Content-Language" content="${generalConfig.language}" />
    <meta name="Author" content="${generalConfig.author}" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="<s:url value="/resources/default/css/style.css" />" >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div id="container">
    <div id="header">
        <header>
            <div class="container-fluid">
                <div class="row header">
                    <div class="col-lg-12">
                        <p class="vcenter">
                            <t:insertAttribute name="header" />
                        </p>
                    </div>
                </div>
            </div>
        </header>
    </div>
    <div id="menu">
        <t:insertAttribute name="menu" />
    </div>

    <div class="container-fluid text-center">
        <div class="row content">
            <div id="leftpanel">
                <t:insertAttribute name="leftpanel" />
            </div>
            <div id="content">
                <t:insertAttribute name="body" />
            </div>
            <div id="rightpanel">
                <t:insertAttribute name="rightpanel" />
            </div>
        </div>
    </div>

    <footer class="container-fluid text-center">
        <div id="footer">
            <t:insertAttribute name="footer" />
        </div>
    </footer>
</div>

</body>
</html>
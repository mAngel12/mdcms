<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>

<html>
	<head>
	  <title> <t:insertAttribute name="title" /> </title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <link rel="stylesheet" href="<s:url value="/resources/admin/css/style.css" />" >
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <script src="<s:url value="/resources/admin/js/script.js" />"></script>
	  <script src="https://cloud.tinymce.com/stable/tinymce.min.js"></script>
	  <script>
		  tinymce.init({
			  selector:'textarea',
              height: 250,
			  menubar: false,
              theme: 'modern',
              plugins: [
                  'advlist autolink lists link image charmap print preview hr anchor pagebreak',
                  'searchreplace wordcount visualblocks visualchars code fullscreen',
                  'insertdatetime media nonbreaking save table contextmenu directionality',
                  'emoticons template paste textcolor colorpicker textpattern imagetools codesample toc help'
              ],
              toolbar: 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | print preview media | forecolor backcolor emoticons',
              image_advtab: true
		  });
	  </script>
	</head>
<body>

<div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>
<div id="wrapper">
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <t:insertAttribute name="header" />
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
				<t:insertAttribute name="menu" />
            </ul>
        </div>
    </nav>
	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row" id="main" >
				<div class="col-sm-12 col-md-12 well" id="content">
	                <t:insertAttribute name="body" />
				</div>
			</div>
		</div>
	</div>
    <footer class="container-fluid text-center">
		<div id="footer">
			<t:insertAttribute name="footer" />
		</div>
	</footer>
</div>
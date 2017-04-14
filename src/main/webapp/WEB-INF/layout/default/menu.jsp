<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
        <c:forEach items="${navigationMenuLinks}" var="navigationMenu">
          <li><a href="${navigationMenu.url}">${navigationMenu.title}</a></li>
        </c:forEach>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="admin/"><span class="glyphicon glyphicon-log-in"></span> Admin Panel</a></li>
      </ul>
    </div>
  </div>
</nav>
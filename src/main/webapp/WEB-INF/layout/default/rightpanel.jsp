<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-2 sidenav">
	<h4><b>Last 5 Posts: </b></h4>
	<div class="well">
		<c:forEach items="${last5Posts}" var="post">
			<p><a href="<c:url value='/post-${post.id}' />">${post.title}</a></p>
		</c:forEach>
    </div>

	<c:forEach items="${rightSidebarPanels}" var="rightSidebar">
		<h4><b>${rightSidebar.title} </b></h4>
		<div class="well">
			${rightSidebar.content}
		</div>
	</c:forEach>
</div>
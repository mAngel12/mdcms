<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-2 sidenav">
	<c:if test = "${categoriesPanelOn}">
		<h4><b>Categories: </b></h4>
		<div class="well">
			<c:forEach items="${categories}" var="category">
				<p><a href="<c:url value='/postcategory-${category.categoryId}' />">${category.categoryName}</a></p>
			</c:forEach>
		</div>
	</c:if>
	<c:forEach items="${leftSidebarPanels}" var="leftSidebar">
		<h4><b>${leftSidebar.title} </b></h4>
		<div class="well">
			${leftSidebar.content}
		</div>
	</c:forEach>
</div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-8 text-left">
    <br>
    <h4><small>ALL POSTS</small></h4>
    <hr>
    <c:forEach items="${posts}" var="post">
        <h5><span class="glyphicon glyphicon-pencil"></span> <a href="<c:url value='/post-${post.id}' />" >${post.title}</a>, Published on ${post.date} in the category "<a href="<c:url value='/postcategory-${post.category.categoryId}' />" >${post.category.categoryName}</a>"</h5>
        <hr>
    </c:forEach>
    <br/>
</div>
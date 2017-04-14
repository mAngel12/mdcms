<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-8 text-left">
    <br>
    <h4><small>RECENT POSTS</small></h4>

    <c:forEach items="${posts}" var="post">
        <hr>
        <h2>${post.title}</h2>
        <h5><span class="glyphicon glyphicon-time"></span> Published on ${post.date} in the category "<a href="<c:url value='/postcategory-${post.category.categoryId}' />" >${post.category.categoryName}</a>"</h5>
        <p>${post.content}</p><br/>
        <div class="viewpost" >
            <a class="btn btn-default" role="button" href="<c:url value='/post-${post.id}' />" > View more/Comment</a>
        </div>
    </c:forEach>
    <br/>
    <br/>
    <div class="viewall" >
        <a class="btn btn-default" role="button" href="<c:url value='/allposts' />" > View All Posts</a>
    </div>
    <br/>
    <br/>
</div>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<li>
	<a href="/home"><i class="fa fa-fw fa-globe"></i> Go to Homepage</a>
</li>

<sec:authorize access="hasRole('ADMIN')">
	<li>
		<a href="/admin/config/general"><i class="fa fa-fw fa-cogs"></i> General Configuration</a>
	</li>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
	<li>
		<a data-toggle="collapse" data-target="#submenu-1"><i class="fa fa-fw fa-user-plus"></i> Admins and Mods<i class="fa fa-fw fa-angle-down pull-right"></i></a>
		<ul id="submenu-1" class="collapse">
			<li><a href="/admin/users/list"><i class="fa fa-angle-double-right"></i> User List</a></li>
			<li><a href="/admin/users/new"><i class="fa fa-angle-double-right"></i> Add User</a></li>
		</ul>
	</li>
</sec:authorize>
<li>
	<a data-toggle="collapse" data-target="#submenu-2"><i class="fa fa-fw fa-newspaper-o"></i> Posts<i class="fa fa-fw fa-angle-down pull-right"></i></a>
	<ul id="submenu-2" class="collapse">
		<li><a href="/admin/posts/posts"><i class="fa fa-angle-double-right"></i> Posts List</a></li>
		<li><a href="/admin/posts/new"><i class="fa fa-angle-double-right"></i> Add Post</a></li>
		<li><a href="/admin/posts/categories"><i class="fa fa-angle-double-right"></i> Categories</a></li>
		<li><a href="/admin/posts/newcategory"><i class="fa fa-angle-double-right"></i> New Category</a></li>
		<li><a href="/admin/posts/comments"><i class="fa fa-angle-double-right"></i> Comments</a></li>
	</ul>
</li>
<li>
	<a data-toggle="collapse" data-target="#submenu-3"><i class="fa fa-fw fa-edit"></i> Pages<i class="fa fa-fw fa-angle-down pull-right"></i></a>
	<ul id="submenu-3" class="collapse">
		<li><a href="/admin/pages/list"><i class="fa fa-angle-double-right"></i> Pages List</a></li>
		<li><a href="/admin/pages/new"><i class="fa fa-angle-double-right"></i> Add Page</a></li>
	</ul>
</li>
<li>
	<a data-toggle="collapse" data-target="#submenu-4"><i class="fa fa-fw fa-star"></i> Website<i class="fa fa-fw fa-angle-down pull-right"></i></a>
	<ul id="submenu-4" class="collapse">
		<li><a href="/admin/website/navmenu_list"><i class="fa fa-angle-double-right"></i> Navigation Menu</a></li>
		<li><a href="/admin/website/leftsidebar_list"><i class="fa fa-angle-double-right"></i> Left Sidebar Editor</a></li>
		<li><a href="/admin/website/rightsidebar_list"><i class="fa fa-angle-double-right"></i> Right Sidebar Editor</a></li>
	</ul>
</li>

<li>
	<a data-toggle="collapse" data-target="#submenu-5"><i class="fa fa-fw fa-magic"></i> Other<i class="fa fa-fw fa-angle-down pull-right"></i></a>
	<ul id="submenu-5" class="collapse">
		<li><a href="/admin/gallery/list"><i class="fa fa-angle-double-right"></i> Gallery</a></li>
		<li><a href="/admin/contactform"><i class="fa fa-angle-double-right"></i> Contact Form  <span class="label label-danger">${newMsgs}</span></a></li>
	</ul>
</li>
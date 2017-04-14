<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/admin/home" >
                <h3><b>mdCMS Admin Panel</b></h3>
            </a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">           
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown"><sec:authorize access="hasRole('ADMIN')">Administrator</sec:authorize><sec:authorize access="hasRole('MOD')">Moderator</sec:authorize> ${loggedinuser}  <b class="fa fa-angle-down"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="/home"><i class="fa fa-fw fa-globe"></i> Go to Homepage</a></li>
                    <li><a href="/admin/myprofile"><i class="fa fa-fw fa-user"></i> Edit Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="/logout"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
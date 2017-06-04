<h2>Dear <strong>${loggedinuser}</strong>, Welcome to Admin Panel!</h2>
<hr>
<br/>
<h4><strong><i class="fa fa-bar-chart"></i> Basic information and statistics: </strong></h4>
<br/>
<ul>
    <li>Your website is called <code class="home-badge">${site.title}</code>.</li>
    <li>The description of the site is: <code class="home-badge">${site.description}</code>.</li>
    <li>The keywords are: <code class="home-badge">${site.keywords}</code>.</li>
    <li>The author of the site is: <code class="home-badge">${site.author}</code>.</li>
    <li>In your database there are <code class="home-badge">${numberOfPosts}</code> posts in <code class="home-badge">${numberOfCategories}</code> categories.</li>
    <li>The last post has the title <code class="home-badge">${lastPost.title}</code>, was published on <code class="home-badge">${lastPost.date}</code> in the <code class="home-badge">${lastPost.category.categoryName}</code> category.</li>
    <li>Your readers shared <code class="home-badge">${numberOfComments}</code> comments under your posts.</li>
    <li>There are <code class="home-badge">${numberOfUsers}</code> created administrator or moderator accounts.</li>
    <li>The site has <code class="home-badge">${numberOfPages}</code> additional subpages.</li>
    <li>You have <code class="home-badge">${numberOfNotReadedMsg}</code> new messages on the contact form. Generally, you have <code class="home-badge">${numberOfMsg}</code> messages.</li>
    <li>There are <code class="home-badge">${numberOfImages}</code> pictures in the gallery.</li>
    <li>You are using <code class="home-badge">mdCMS v${version}</code>. Check for updates at <a href="http://dultzdev.com" >dultzdev.com</a>.</li>
</ul>
<h2>Dear <strong>${loggedinuser}</strong>, Welcome to Admin Panel!</h2>
<hr>
<br/>
<h4><strong><i class="fa fa-bar-chart"></i> Basic information and statistics: </strong></h4>
<br/>
<ul>
    <li>Your website is called <span class="label label-default">${site.title}</span>.</li>
    <li>The description of the site is: <span class="label label-default">${site.description}</span>.</li>
    <li>The keywords are: <span class="label label-default">${site.keywords}</span>.</li>
    <li>The author of the site is: <span class="label label-default">${site.author}</span>.</li>
    <li>In your database there are <span class="label label-default">${numberOfPosts}</span> posts in <span class="label label-default">${numberOfCategories}</span> categories.</li>
    <li>The last post has the title <span class="label label-default">${lastPost.title}</span>, was published on <span class="label label-default">${lastPost.date}</span> in the <span class="label label-default">${lastPost.category.categoryName}</span> category.</li>
    <li>Your readers shared <span class="label label-default">${numberOfComments}</span> comments under your posts.</li>
    <li>There are <span class="label label-default">${numberOfUsers}</span> created administrator or moderator accounts.</li>
    <li>The site has <span class="label label-default">${numberOfPages}</span> additional subpages.</li>
    <li>You have <span class="label label-default">${numberOfNotReadedMsg}</span> new messages on the contact form. Generally, you have <span class="label label-default">${numberOfMsg}</span> messages.</li>
    <li>There are <span class="label label-default">${numberOfImages}</span> pictures in the gallery.</li>
</ul>
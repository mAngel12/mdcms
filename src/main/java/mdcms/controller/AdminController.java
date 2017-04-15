package mdcms.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import mdcms.model.*;
import mdcms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AdminController {

	@Autowired
	UserService userService;

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	PostService postService;

	@Autowired
	PostCategoryService postCategoryService;

	@Autowired
	PostCommentService postCommentService;

	@Autowired
	GeneralConfigurationService generalConfigurationService;

	@Autowired
	PageService pageService;

	@Autowired
	NavigationMenuService navigationMenuService;

	@Autowired
	LeftSidebarService leftSidebarService;

	@Autowired
	RightSidebarService rightSidebarService;

	@Autowired
	GalleryService galleryService;

	@Autowired
	ContactService contactService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	/** Admin Homepage */
	@RequestMapping(value = { "/admin/", "/admin/home" }, method = RequestMethod.GET)
	public String homeAdmin(ModelMap model) {
		model.addAttribute("site", generalConfigurationService.getConfig());
		model.addAttribute("numberOfPosts", postService.getPosts().size());
		model.addAttribute("numberOfCategories", postCategoryService.getCategories().size());
		model.addAttribute("lastPost", postService.getLastPosts(1).get(0));
		model.addAttribute("numberOfComments", postCommentService.getComments().size());
		model.addAttribute("numberOfUsers", userService.findAllUsers().size());
		model.addAttribute("numberOfPages", pageService.getPages().size());
		model.addAttribute("numberOfNotReadedMsg", contactService.getContactPostsNotReaded().size());
		model.addAttribute("numberOfMsg", contactService.getContactPosts().size());
		model.addAttribute("numberOfImages",galleryService.getGallery().size());
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/home";
	}

	/** Admin Users Panel */
	@RequestMapping(value = "/admin/users/list", method = RequestMethod.GET)
	public String listUsersAdmin(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/users/list";
	}

	@RequestMapping(value = { "/admin/users/new" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/users/user";
	}

	@RequestMapping(value = { "/admin/users/new" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
						   ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/users/user";
		}


		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError = new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
			result.addError(ssoError);
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/users/user";
		}

		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/users/user-success";
	}


	@RequestMapping(value = { "/admin/users/edit-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/users/user";
	}

	@RequestMapping(value = { "/admin/users/edit-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
							 ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			model.addAttribute("edit", true);
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/users/user";
		}

		userService.updateUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/users/user-success";
	}


	@RequestMapping(value = { "/admin/users/delete-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/admin/users/list";
	}

	/** Posts */

	@RequestMapping(value = "/admin/posts/posts", method = RequestMethod.GET)
	public String listPostsAdmin(ModelMap model) {
		List<Post> posts = postService.getPosts();
		model.addAttribute("posts", posts);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/posts/posts";
	}

	@RequestMapping(value = { "/admin/posts/new" }, method = RequestMethod.GET)
	public String newPost(ModelMap model) {
		model.addAttribute("post", new Post());
		model.addAttribute("categories", postCategoryService.getCategories());
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/posts/post";
	}

	@RequestMapping(value = { "/admin/posts/new" }, method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result,
						   ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("categories", postCategoryService.getCategories());
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/posts/post";
		}


		postService.addPost(post);

		model.addAttribute("success", "Post " + post.getTitle()  + " added successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/posts/post-success";
	}


	@RequestMapping(value = { "/admin/posts/edit-{id}" }, method = RequestMethod.GET)
	public String editPost(@PathVariable int id, ModelMap model) {
		model.addAttribute("post", postService.getPost(id));
		model.addAttribute("categories", postCategoryService.getCategories());
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/posts/post";
	}

	@RequestMapping(value = { "/admin/posts/edit-{id}" }, method = RequestMethod.POST)
	public String updateUser(@Valid Post post, BindingResult result,
							 ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			model.addAttribute("edit", true);
			model.addAttribute("categories", postCategoryService.getCategories());
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/posts/post";
		}

		postService.addPost(post);

		model.addAttribute("success", "Post " + post.getTitle() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/posts/post-success";
	}


	@RequestMapping(value = { "/admin/posts/delete-{id}" }, method = RequestMethod.GET)
	public String deletePost(@PathVariable int id) {
		postService.deletePost(id);
		return "redirect:/admin/posts/posts";
	}

	/** Posts Categories */

	@RequestMapping(value = "/admin/posts/categories", method = RequestMethod.GET)
	public String listCategoriesAdmin(ModelMap model) {

		List<PostCategory> categories = postCategoryService.getCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/posts/categories";
	}

	@RequestMapping(value = { "/admin/posts/newcategory" }, method = RequestMethod.GET)
	public String newCategory(ModelMap model) {
		model.addAttribute("postCategory", new PostCategory());
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/posts/category";
	}

	@RequestMapping(value = { "/admin/posts/newcategory" }, method = RequestMethod.POST)
	public String saveCategory(@Valid PostCategory postCategory, BindingResult result,
						   ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/posts/category";
		}


		postCategoryService.addCategory(postCategory);

		model.addAttribute("success", "Category " + postCategory.getCategoryName()  + " added successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/posts/category-success";
	}


	@RequestMapping(value = { "/admin/posts/editcategory-{id}" }, method = RequestMethod.GET)
	public String editCategory(@PathVariable int id, ModelMap model) {
		model.addAttribute("postCategory", postCategoryService.getCategory(id));
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/posts/category";
	}

	@RequestMapping(value = { "/admin/posts/editcategory-{id}" }, method = RequestMethod.POST)
	public String updateCategory(@Valid PostCategory postCategory, BindingResult result,
							 ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			model.addAttribute("edit", true);
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/posts/category";
		}

		postCategoryService.addCategory(postCategory);

		model.addAttribute("success", "Category " + postCategory.getCategoryName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/posts/category-success";
	}


	@RequestMapping(value = { "/admin/posts/deletecategory-{id}" }, method = RequestMethod.GET)
	public String deleteCategory(@PathVariable int id, ModelMap model) {
		model.addAttribute("categories", postCategoryService.getCategories());
		postCategoryService.deleteCategory(id);
		return "redirect:/admin/posts/categories";
	}

	@RequestMapping(value = "/admin/posts/comments", method = RequestMethod.GET)
	public String listCommentsAdmin(ModelMap model) {
		List<PostComment> comments = postCommentService.getComments();
		model.addAttribute("comments", comments);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/posts/comments";
	}

	@RequestMapping(value = { "/admin/posts/deletecomment-{id}" }, method = RequestMethod.GET)
	public String deleteComment(@PathVariable int id, ModelMap model) {
		model.addAttribute("comments", postCommentService.getComment(id));
		postCommentService.deleteComment(id);
		return "redirect:/admin/posts/comments";
	}

	/** Configuration */

	@RequestMapping(value = { "/admin/config/general" }, method = RequestMethod.GET)
	public String editGeneralConfig(ModelMap model) {
		model.addAttribute("generalConfiguration", generalConfigurationService.getConfig());
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/config/general";
	}

	@RequestMapping(value = { "/admin/config/general" }, method = RequestMethod.POST)
	public String updateGeneralConfig(@Valid GeneralConfiguration generalConfiguration, BindingResult result,
								 ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/config/general";
		}

		generalConfigurationService.saveConfig(generalConfiguration);

		model.addAttribute("success", "General configuration updated successfully.");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/config/general-success";
	}

	/** Pages */

	@RequestMapping(value = "/admin/pages/list", method = RequestMethod.GET)
	public String listPagesAdmin(ModelMap model) {
		List<Page> pages = pageService.getPages();
		model.addAttribute("pages", pages);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/pages/list";
	}

	@RequestMapping(value = { "/admin/pages/new" }, method = RequestMethod.GET)
	public String newPage(ModelMap model) {
		model.addAttribute("page", new Page());
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/pages/page";
	}

	@RequestMapping(value = { "/admin/pages/new" }, method = RequestMethod.POST)
	public String savePost(@Valid Page page, BindingResult result,
						   ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/pages/page";
		}

		if(!pageService.isAddressIdUnique(page.getId(), page.getAddressId())){
			FieldError addressIdError = new FieldError("page","addressId", messageSource.getMessage("non.unique.addressId", new String[]{page.getAddressId()}, Locale.getDefault()));
			result.addError(addressIdError);
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/pages/page";
		}

		pageService.addPage(page);

		model.addAttribute("success", "Page " + page.getTitle()  + " added successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/pages/page-success";
	}

	@RequestMapping(value = { "/admin/pages/edit-{addressId}" }, method = RequestMethod.GET)
	public String editPage(@PathVariable String addressId, ModelMap model) {
		Page page = pageService.getPageByAddressId(addressId);
		model.addAttribute("page", page);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/pages/page";
	}

	@RequestMapping(value = { "/admin/pages/edit-{addressId}" }, method = RequestMethod.POST)
	public String updatePage(@Valid Page page, BindingResult result,
								 ModelMap model, @PathVariable String addressId) {

		if (result.hasErrors()) {
			model.addAttribute("edit", true);
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/pages/page";
		}

		if(!pageService.isAddressIdUnique(page.getId(), page.getAddressId())){
			FieldError addressIdError = new FieldError("page","addressId", messageSource.getMessage("non.unique.addressId", new String[]{page.getAddressId()}, Locale.getDefault()));
			result.addError(addressIdError);
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/pages/page";
		}

		pageService.addPage(page);

		model.addAttribute("success", "Page " + page.getTitle() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/pages/page-success";
	}

	@RequestMapping(value = { "/admin/pages/delete-{addressId}" }, method = RequestMethod.GET)
	public String deletePage(@PathVariable String addressId, ModelMap model) {
		model.addAttribute("pages", pageService.getPages());
		pageService.deletePageByAddressId(addressId);
		return "redirect:/admin/pages/list";
	}

	/** Nav Menu */

	@RequestMapping(value = "/admin/website/navmenu_list", method = RequestMethod.GET)
	public String listNavMenuAdmin(ModelMap model) {
		List<NavigationMenu> navigationMenuLinks = navigationMenuService.getNavs();
		model.addAttribute("navigationMenuLinks", navigationMenuLinks);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/navmenu_list";
	}

	@RequestMapping(value = { "/admin/website/newnavmenu" }, method = RequestMethod.GET)
	public String newNavMenu(ModelMap model) {
		model.addAttribute("navigationMenu", new NavigationMenu());
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/navmenu";
	}

	@RequestMapping(value = { "/admin/website/newnavmenu" }, method = RequestMethod.POST)
	public String saveNavMenu(@Valid NavigationMenu navigationMenu, BindingResult result,
						   ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/website/navmenu";
		}

		navigationMenuService.addNav(navigationMenu);

		model.addAttribute("success", "Navigation Menu Link " + navigationMenu.getTitle()  + " added successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/navmenu-success";
	}

	@RequestMapping(value = { "/admin/website/editnavmenu-{id}" }, method = RequestMethod.GET)
	public String editNavMenu(@PathVariable int id, ModelMap model) {
		NavigationMenu navigationMenu = navigationMenuService.getNav(id);
		model.addAttribute("navigationMenu", navigationMenu);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/navmenu";
	}

	@RequestMapping(value = { "/admin/website/editnavmenu-{id}" }, method = RequestMethod.POST)
	public String updateNavMenu(@Valid NavigationMenu navigationMenu, BindingResult result,
							 ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			model.addAttribute("edit", true);
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/website/navmenu";
		}

		navigationMenuService.addNav(navigationMenu);

		model.addAttribute("success", "Navigation Menu Link " + navigationMenu.getTitle() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/navmenu-success";
	}

	@RequestMapping(value = { "/admin/website/deletenavmenu-{id}" }, method = RequestMethod.GET)
	public String deleteNavMenu(@PathVariable int id, ModelMap model) {
		navigationMenuService.deleteNav(id);
		model.addAttribute("navigationMenuLinks", navigationMenuService.getNavs());
		return "redirect:/admin/website/navmenu_list";
	}

	/** Left Sidebar Menu */

	@RequestMapping(value = "/admin/website/leftsidebar_list", method = RequestMethod.GET)
	public String listLeftSidebarAdmin(ModelMap model) {
		List<LeftSidebar> leftSidebarPanels = leftSidebarService.getPanels();
		model.addAttribute("leftSidebarPanels", leftSidebarPanels);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/leftsidebar_list";
	}

	@RequestMapping(value = { "/admin/website/newleftsidebar" }, method = RequestMethod.GET)
	public String newLeftSidebar(ModelMap model) {
		model.addAttribute("leftSidebar", new LeftSidebar());
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/leftsidebar";
	}

	@RequestMapping(value = { "/admin/website/newleftsidebar" }, method = RequestMethod.POST)
	public String saveLeftSidebar(@Valid LeftSidebar leftSidebar, BindingResult result,
							  ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/website/leftsidebar";
		}

		leftSidebarService.addPanel(leftSidebar);

		model.addAttribute("success", "Left Sidebar Panel " + leftSidebar.getTitle()  + " added successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/leftsidebar-success";
	}

	@RequestMapping(value = { "/admin/website/editleftsidebar-{id}" }, method = RequestMethod.GET)
	public String editLeftSidebar(@PathVariable int id, ModelMap model) {
		LeftSidebar leftSidebar = leftSidebarService.getPanel(id);
		model.addAttribute("leftSidebar", leftSidebar);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/leftsidebar";
	}

	@RequestMapping(value = { "/admin/website/editleftsidebar-{id}" }, method = RequestMethod.POST)
	public String updateLeftSidebar(@Valid LeftSidebar leftSidebar, BindingResult result,
								ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			model.addAttribute("edit", true);
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/website/leftsidebar";
		}

		leftSidebarService.addPanel(leftSidebar);

		model.addAttribute("success", "Left Sidebar Panel " + leftSidebar.getTitle() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/leftsidebar-success";
	}

	@RequestMapping(value = { "/admin/website/deleteleftsidebar-{id}" }, method = RequestMethod.GET)
	public String deleteLeftSidebar(@PathVariable int id, ModelMap model) {
		leftSidebarService.deletePanel(id);
		model.addAttribute("leftSidebarPanels", leftSidebarService.getPanels());
		return "redirect:/admin/website/leftsidebar_list";
	}

	/** Right Sidebar Menu */

	@RequestMapping(value = "/admin/website/rightsidebar_list", method = RequestMethod.GET)
	public String listRightSidebarAdmin(ModelMap model) {
		List<RightSidebar> rightSidebarPanels = rightSidebarService.getPanels();
		model.addAttribute("rightSidebarPanels", rightSidebarPanels);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/rightsidebar_list";
	}

	@RequestMapping(value = { "/admin/website/newrightsidebar" }, method = RequestMethod.GET)
	public String newRightSidebar(ModelMap model) {
		model.addAttribute("rightSidebar", new RightSidebar());
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/rightsidebar";
	}

	@RequestMapping(value = { "/admin/website/newrightsidebar" }, method = RequestMethod.POST)
	public String saveRightSidebar(@Valid RightSidebar rightSidebar, BindingResult result,
								  ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/website/rightsidebar";
		}

		rightSidebarService.addPanel(rightSidebar);

		model.addAttribute("success", "Right Sidebar Panel " + rightSidebar.getTitle()  + " added successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/rightsidebar-success";
	}

	@RequestMapping(value = { "/admin/website/editrightsidebar-{id}" }, method = RequestMethod.GET)
	public String editRightSidebar(@PathVariable int id, ModelMap model) {
		RightSidebar rightSidebar = rightSidebarService.getPanel(id);
		model.addAttribute("rightSidebar", rightSidebar);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/rightsidebar";
	}

	@RequestMapping(value = { "/admin/website/editrightsidebar-{id}" }, method = RequestMethod.POST)
	public String updateRightSidebar(@Valid RightSidebar rightSidebar, BindingResult result,
									ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			model.addAttribute("edit", true);
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/website/rightsidebar";
		}

		rightSidebarService.addPanel(rightSidebar);

		model.addAttribute("success", "Right Sidebar Panel " + rightSidebar.getTitle() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/website/rightsidebar-success";
	}

	@RequestMapping(value = { "/admin/website/deleterightsidebar-{id}" }, method = RequestMethod.GET)
	public String deleteRightSidebar(@PathVariable int id, ModelMap model) {
		rightSidebarService.deletePanel(id);
		model.addAttribute("rightSidebarPanels", rightSidebarService.getPanels());
		return "redirect:/admin/website/rightsidebar_list";
	}

	/** My Profile Editor */

	@RequestMapping(value = { "/admin/myprofile" }, method = RequestMethod.GET)
	public String editMyProfile(ModelMap model) {
		model.addAttribute("user", userService.findBySSO(getPrincipal()));
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/myprofile";
	}

	@RequestMapping(value = { "/admin/myprofile" }, method = RequestMethod.POST)
	public String updateMyProfile(@Valid User user, BindingResult result,
							 ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/myprofile";
		}

		userService.updateUser(user);

		model.addAttribute("success", "Your profile updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/myprofile-success";
	}

	/** Gallery */

	@RequestMapping(value = "/admin/gallery/list", method = RequestMethod.GET)
	public String listGalleryAdmin(ModelMap model) {
		List<Gallery> gallery = galleryService.getGallery();
		model.addAttribute("gallery", gallery);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/gallery/list";
	}

	@RequestMapping(value = { "/admin/gallery/new" }, method = RequestMethod.GET)
	public String newImage(ModelMap model) {
		model.addAttribute("gallery", new Gallery());
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/gallery/image";
	}

	@RequestMapping(value = { "/admin/gallery/new" }, method = RequestMethod.POST)
	public String saveImage(@Valid Gallery gallery, BindingResult result,
						   ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/gallery/image";
		}


		galleryService.addImage(gallery);

		model.addAttribute("success", "Image " + gallery.getTitle()  + " added successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/gallery/image-success";
	}


	@RequestMapping(value = { "/admin/gallery/edit-{id}" }, method = RequestMethod.GET)
	public String editImage(@PathVariable int id, ModelMap model) {
		model.addAttribute("gallery", galleryService.getImage(id));
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/gallery/image";
	}

	@RequestMapping(value = { "/admin/gallery/edit-{id}" }, method = RequestMethod.POST)
	public String updateUser(@Valid Gallery gallery, BindingResult result,
							 ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			model.addAttribute("edit", true);
			model.addAttribute("loggedinuser", getPrincipal());
			return "admin/gallery/image";
		}

		galleryService.addImage(gallery);

		model.addAttribute("success", "Image " + gallery.getTitle() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/gallery/image-success";
	}


	@RequestMapping(value = { "/admin/gallery/delete-{id}" }, method = RequestMethod.GET)
	public String deleteImage(@PathVariable int id) {
		galleryService.deleteImage(id);
		return "redirect:/admin/gallery/list";
	}

	/** Contact Form */

	@RequestMapping(value = "/admin/contactform", method = RequestMethod.GET)
	public String listContactMsgAdmin(ModelMap model) {
		List<Contact> notReadedMsg = contactService.getContactPostsNotReaded();
		List<Contact> readedMsg = contactService.getContactPostsReaded();
		model.addAttribute("notReadedMsg", notReadedMsg);
		model.addAttribute("readedMsg", readedMsg);
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/contactform";
	}

	@RequestMapping(value = { "/admin/contactform_readedmsg-{id}" }, method = RequestMethod.GET)
	public String doReadedContactMsg(@PathVariable int id) {
		contactService.readContactPost(id);
		return "redirect:/admin/contactform";
	}

	@RequestMapping(value = { "/admin/contactform_notreadedmsg-{id}" }, method = RequestMethod.GET)
	public String doNotReadedContactMsg(@PathVariable int id) {
		contactService.notReadContactPost(id);
		return "redirect:/admin/contactform";
	}

	@RequestMapping(value = { "/admin/contactform_deletemsg-{id}" }, method = RequestMethod.GET)
	public String deleteContactMsg(@PathVariable int id) {
		contactService.deleteContactPost(id);
		return "redirect:/admin/contactform";
	}

	/** Number of not readed msg in Contact Form */
	@ModelAttribute("newMsgs")
	public int newMsgs() {
		return contactService.getContactPostsNotReaded().size();
	}

	/** Roles */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}

	/** Access Denied */
	@RequestMapping(value = "/admin/accessdenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "admin/accessdenied";
	}


	/** Log-in Panel */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
		} else {
			return "redirect:/admin";
		}
	}

	/** Logout */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}


	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}

}
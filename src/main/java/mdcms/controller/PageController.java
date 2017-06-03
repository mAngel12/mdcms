package mdcms.controller;

import mdcms.model.*;
import mdcms.model.other.PostWithNumberOfComments;
import mdcms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class PageController {

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
	LeftSidebarService leftSidebarService;

	@Autowired
	RightSidebarService rightSidebarService;

	@Autowired
	GalleryService galleryService;

	@Autowired
	ContactService contactService;

	@Autowired
	NavigationMenuService navigationMenuService;

	@RequestMapping(value = {"/", "home", "posts"}, method = RequestMethod.GET)
	public String home(ModelMap model) {
		List<Post> lastPosts = postService.getLastPosts(10);
		List<PostWithNumberOfComments> posts = new ArrayList<PostWithNumberOfComments>();
		for(int i = 0; i < 10; i++) {
			posts.add(new PostWithNumberOfComments(lastPosts.get(i), postCommentService.getCommentsByPost(lastPosts.get(i).getId()).size()));
		}
		model.addAttribute("posts", posts);
		return "home";
	}
	@RequestMapping(value = { "post-{id}" }, method = RequestMethod.GET)
	public String post(@PathVariable int id, ModelMap model) {
		model.addAttribute("postComment", new PostComment());
		model.addAttribute("post", postService.getPost(id));
		model.addAttribute("numberOfComments", postCommentService.getCommentsByPost(id).size());
		model.addAttribute("comments", postCommentService.getCommentsByPost(id));
		return "post";
	}

	@RequestMapping(value = { "post-{id}" }, method = RequestMethod.POST)
	public String addComment(@Valid PostComment postComment, BindingResult result,
							 ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			model.addAttribute("post", postService.getPost(id));
			model.addAttribute("numberOfComments", postCommentService.getCommentsByPost(id).size());
			model.addAttribute("comments", postCommentService.getCommentsByPost(id));
			return "post";
		}

		postCommentService.addComment(postComment);

		model.addAttribute("postComment", new PostComment());
		model.addAttribute("post", postService.getPost(id));
		model.addAttribute("numberOfComments", postCommentService.getCommentsByPost(id).size());
		model.addAttribute("comments", postCommentService.getCommentsByPost(id));
		return "post";
	}

	@RequestMapping(value = { "allposts" }, method = RequestMethod.GET)
	public String allPosts(ModelMap model) {
		model.addAttribute("posts", postService.getPosts());
		return "allposts";
	}

	@RequestMapping(value = { "postcategory-{id}" }, method = RequestMethod.GET)
	public String postCategory(@PathVariable int id, ModelMap model)
	{
		model.addAttribute("category", postCategoryService.getCategory(id));
		model.addAttribute("posts", postService.getPostsByCategory(id));
		return "postcategory";
	}

	@RequestMapping(value = { "page-{addressId}" }, method = RequestMethod.GET)
	public String page(@PathVariable String addressId, ModelMap model) {
		model.addAttribute("page", pageService.getPageByAddressId(addressId));
		return "page";
	}

	@RequestMapping(value = { "gallery" }, method = RequestMethod.GET)
	public String gallery(ModelMap model) {
		model.addAttribute("gallery", galleryService.getGallery());
		return "gallery";
	}

	@RequestMapping(value = { "contact" }, method = RequestMethod.GET)
	public String contact(ModelMap model) {
		model.addAttribute("contact", new Contact());
		return "contact";
	}

	@RequestMapping(value = { "contact" }, method = RequestMethod.POST)
	public String addMsg(@Valid Contact contact, BindingResult result,
							 ModelMap model) {

		if (result.hasErrors()) {
			return "contact";
		}

		contactService.addContactPost(contact);

		return "redirect:/contact?success";
	}

	@ModelAttribute("generalConfig")
	public GeneralConfiguration generalConfig() {
		return generalConfigurationService.getConfig();
	}
	@ModelAttribute("last5Posts")
	public List<Post> last5Posts() {
		return postService.getLastPosts(5);
	}
	@ModelAttribute("categories")
	public List<PostCategory> categories() {
		return postCategoryService.getCategories();
	}
	@ModelAttribute("navigationMenuLinks")
	public List<NavigationMenu> navigationMenuLinks() {
		return navigationMenuService.getNavs();
	}
	@ModelAttribute("leftSidebarPanels")
	public List<LeftSidebar> leftSidebarPanels() {
		return leftSidebarService.getPanels();
	}
	@ModelAttribute("rightSidebarPanels")
	public List<RightSidebar> rightSidebarPanels() {
		return rightSidebarService.getPanels();
	}
}
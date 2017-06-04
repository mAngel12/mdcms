package mdcms.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="SETTINGS")
public class Settings {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @NotNull
    @Column(name="WEB_POSTS_IN_HOMEPAGE")
    private Integer postsInHomepage;

    @NotNull
    @Column(name="WEB_COMMENTING_ON_POSTS")
    private boolean commentingOnPosts;

    @NotNull
    @Column(name="WEB_LAST5POSTS_ON_RIGHT_SIDEBAR")
    private boolean last5postsOnRightSidebar;

    @NotNull
    @Column(name="WEB_CATEGORIES_ON_LEFT_SIDEBAR")
    private boolean categoriesOnLeftSidebar;

    @NotNull
    @Column(name="WEB_LINK_TO_ADMIN_PANEL_IN_MENU")
    private boolean linkToAdminPanelInMenu;

    @Column(name="WEB_TINYMCE_CLOUD_API_KEY")
    private String tinyMCECloudAPIKey;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostsInHomepage() {
        return postsInHomepage;
    }
    public void setPostsInHomepage(Integer postsInHomepage) {
        this.postsInHomepage = postsInHomepage;
    }

    public boolean isCommentingOnPosts() {
        return commentingOnPosts;
    }
    public void setCommentingOnPosts(boolean commentingOnPosts) {
        this.commentingOnPosts = commentingOnPosts;
    }

    public boolean isLast5postsOnRightSidebar() {
        return last5postsOnRightSidebar;
    }
    public void setLast5postsOnRightSidebar(boolean last5postsOnRightSidebar) {
        this.last5postsOnRightSidebar = last5postsOnRightSidebar;
    }

    public boolean isCategoriesOnLeftSidebar() {
        return categoriesOnLeftSidebar;
    }
    public void setCategoriesOnLeftSidebar(boolean categoriesOnLeftSidebar) {
        this.categoriesOnLeftSidebar = categoriesOnLeftSidebar;
    }

    public boolean isLinkToAdminPanelInMenu() {
        return linkToAdminPanelInMenu;
    }
    public void setLinkToAdminPanelInMenu(boolean linkToAdminPanelInMenu) {
        this.linkToAdminPanelInMenu = linkToAdminPanelInMenu;
    }

    public String getTinyMCECloudAPIKey() {
        return tinyMCECloudAPIKey;
    }
    public void setTinyMCECloudAPIKey(String tinyMCECloudAPIKey) {
        this.tinyMCECloudAPIKey = tinyMCECloudAPIKey;
    }
}

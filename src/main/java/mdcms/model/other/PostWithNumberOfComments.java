package mdcms.model.other;


import mdcms.model.Post;

public class PostWithNumberOfComments extends Post {

    protected Integer numberOfComments;

    public PostWithNumberOfComments(Post post, Integer numberOfComments) {
        id = post.getId();
        title = post.getTitle();
        date = post.getDate();
        category = post.getCategory();
        content = post.getContent();
        this.numberOfComments = numberOfComments;

    }

    public Integer getNumberOfComments() {
        return numberOfComments;
    }
    public void setNumberOfComments(Integer numberOfComments) {
        this.numberOfComments = numberOfComments;
    }
}

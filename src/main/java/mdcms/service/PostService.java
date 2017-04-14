package mdcms.service;

import java.util.List;

import mdcms.model.Post;

public interface PostService {

    void addPost(Post post);

    List<Post> getPosts();

    List<Post> getLastPosts(int numbers);

    List<Post> getPostsByCategory(int id);

    Post getPost(int id);

    void deletePost(int id);
}
package mdcms.dao;

import java.util.List;

import mdcms.model.Post;

public interface PostDao {

    void addPost(Post post);

    List<Post> getPosts();

    List<Post> getLastPosts(int numbers);

    List<Post> getPostsByCategory(int categoryId);

    Post getPost(int id);

    void deletePost(int id);
}
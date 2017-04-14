package mdcms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mdcms.model.Post;
import mdcms.dao.PostDao;

@Service("postService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPost(Post post) {
        postDao.addPost(post);
    }

    public List<Post> getPosts() {
        return postDao.getPosts();
    }

    public List<Post> getLastPosts(int numbers) {
        return postDao.getLastPosts(numbers);
    }

    public List<Post> getPostsByCategory(int id)
    {
        return postDao.getPostsByCategory(id);
    }

    @Override
    public Post getPost(int id) {
        return postDao.getPost(id);
    }

    @Override
    public void deletePost(int id) {
        postDao.deletePost(id);
    }

}
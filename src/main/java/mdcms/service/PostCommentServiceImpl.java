package mdcms.service;


import mdcms.dao.PostCommentDao;
import mdcms.model.PostComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PostCommentServiceImpl implements PostCommentService{

    @Autowired
    private PostCommentDao postCommentDao;

    @Override
    public void addComment(PostComment comment) {
        postCommentDao.addComment(comment);
    }

    @Override
    public List<PostComment> getComments() {
        return postCommentDao.getComments();
    }

    @Override
    public List<PostComment> getCommentsByPost(int id) {
        return postCommentDao.getCommentsByPost(id);
    }

    @Override
    public PostComment getComment(int id) {
        return postCommentDao.getComment(id);
    }

    @Override
    public void deleteComment(int id) {
        postCommentDao.deleteComment(id);
    }
}

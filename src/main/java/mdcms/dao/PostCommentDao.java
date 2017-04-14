package mdcms.dao;


import mdcms.model.PostComment;

import java.util.List;

public interface PostCommentDao {

    void addComment(PostComment comment);

    List<PostComment> getComments();

    List<PostComment> getCommentsByPost(int postid);

    PostComment getComment(int id);

    void deleteComment(int id);
}
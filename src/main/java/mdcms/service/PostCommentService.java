package mdcms.service;


import java.util.List;

import mdcms.model.PostComment;

public interface PostCommentService {

    void addComment(PostComment comment);

    List<PostComment> getComments();

    List<PostComment> getCommentsByPost(int id);

    PostComment getComment(int id);

    void deleteComment(int id);
}
package mdcms.dao;

import mdcms.model.PostComment;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentDao")
public class PostCommentDaoImpl implements PostCommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addComment(PostComment comment) {
        sessionFactory.getCurrentSession().saveOrUpdate(comment);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PostComment> getComments() {
        return (List<PostComment>) sessionFactory.getCurrentSession().createCriteria(PostComment.class).addOrder(Order.desc("date")).addOrder(Order.desc("id")).list();
    }

    public List<PostComment> getCommentsByPost(int postid) {
        return (List<PostComment>) sessionFactory.getCurrentSession().createCriteria(PostComment.class).add(Restrictions.like("post.id", postid)).addOrder(Order.desc("date")).addOrder(Order.desc("id")).list();
    }

    @Override
    public PostComment getComment(int id) {
        return (PostComment) sessionFactory.getCurrentSession().get(PostComment.class, id);
    }

    @Override
    public void deleteComment(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM POST_COMMENTS WHERE id = "+id).executeUpdate();
    }
}
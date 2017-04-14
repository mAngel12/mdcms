package mdcms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mdcms.model.Post;

@Repository("postDao")
public class PostDaoImpl implements PostDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPost(Post post) {
        sessionFactory.getCurrentSession().saveOrUpdate(post);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Post> getPosts() {
        return (List<Post>) sessionFactory.getCurrentSession().createCriteria(Post.class).addOrder(Order.desc("date")).addOrder(Order.desc("id")).list();
    }

    public List<Post> getLastPosts(int numbers) {
        return (List<Post>) sessionFactory.getCurrentSession().createCriteria(Post.class).addOrder(Order.desc("date")).addOrder(Order.desc("id")).setMaxResults(numbers).list();
    }

    public List<Post> getPostsByCategory(int categoryId){
        return (List<Post>) sessionFactory.getCurrentSession().createCriteria(Post.class).add(Restrictions.like("category.category_id", categoryId )).addOrder(Order.desc("date")).addOrder(Order.desc("id")).list();
    }

    @Override
    public Post getPost(int id) {
        return (Post) sessionFactory.getCurrentSession().get(Post.class, id);
    }

    @Override
    public void deletePost(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM POST_COMMENTS WHERE post_id = "+id).executeUpdate();
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM POSTS WHERE id = "+id).executeUpdate();
    }

}
package mdcms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mdcms.model.PostCategory;

@Repository("categoryDao")
public class PostCategoryDaoImpl implements PostCategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCategory(PostCategory postCategory) {
        sessionFactory.getCurrentSession().saveOrUpdate(postCategory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PostCategory> getCategories() {
        return (List<PostCategory>) sessionFactory.getCurrentSession().createCriteria(PostCategory.class).addOrder(Order.asc("category_name")).list();
    }

    @Override
    public PostCategory getCategory(int category_id) {
        return (PostCategory) sessionFactory.getCurrentSession().get(PostCategory.class, category_id);
    }

    @Override
    public void deleteCategory(int category_id) {
        sessionFactory.getCurrentSession().createSQLQuery("UPDATE POSTS SET category_id = 1 WHERE category_id = "+category_id).executeUpdate();
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM POST_CATEGORY WHERE category_id = "+category_id).executeUpdate();
    }

}
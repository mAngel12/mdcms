package mdcms.dao;

import mdcms.model.Page;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pageDao")
public class PageDaoImpl implements PageDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPage(Page page) {
        sessionFactory.getCurrentSession().saveOrUpdate(page);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Page> getPages() {
        return (List<Page>) sessionFactory.getCurrentSession().createCriteria(Page.class).addOrder(Order.asc("title")).list();
    }

    @Override
    public Page getPageById(int id) {
        return (Page) sessionFactory.getCurrentSession().get(Page.class, id);
    }

    @Override
    public Page getPageByAddressId(String addressId) {
        return (Page) sessionFactory.getCurrentSession().createCriteria(Page.class).add(Restrictions.eq("addressId", addressId)).uniqueResult();
    }

    @Override
    public void deletePageByAddressId(String addressId) {
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM PAGES WHERE address_id = '"+addressId+"'").executeUpdate();
    }

    @Override
    public void deletePageById(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM PAGES WHERE id = "+id).executeUpdate();
    }
}
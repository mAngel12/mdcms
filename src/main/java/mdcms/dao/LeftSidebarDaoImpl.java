package mdcms.dao;

import mdcms.model.LeftSidebar;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("leftSidebarDao")
public class LeftSidebarDaoImpl implements LeftSidebarDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPanel(LeftSidebar panel) {
        sessionFactory.getCurrentSession().saveOrUpdate(panel);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<LeftSidebar> getPanels() {
        return (List<LeftSidebar>) sessionFactory.getCurrentSession().createCriteria(LeftSidebar.class).addOrder(Order.asc("order")).list();
    }

    @Override
    public LeftSidebar getPanel(int id) {
        return (LeftSidebar) sessionFactory.getCurrentSession().get(LeftSidebar.class, id);
    }

    @Override
    public void deletePanel(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM LEFT_SIDEBAR WHERE id = "+id).executeUpdate();
    }
}

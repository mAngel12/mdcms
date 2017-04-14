package mdcms.dao;

import mdcms.model.RightSidebar;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("rightSidebarDao")
public class RightSidebarDaoImpl implements RightSidebarDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPanel(RightSidebar panel) {
        sessionFactory.getCurrentSession().saveOrUpdate(panel);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RightSidebar> getPanels() {
        return (List<RightSidebar>) sessionFactory.getCurrentSession().createCriteria(RightSidebar.class).addOrder(Order.asc("order")).list();
    }

    @Override
    public RightSidebar getPanel(int id) {
        return (RightSidebar) sessionFactory.getCurrentSession().get(RightSidebar.class, id);
    }

    @Override
    public void deletePanel(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM RIGHT_SIDEBAR WHERE id = "+id).executeUpdate();
    }
}

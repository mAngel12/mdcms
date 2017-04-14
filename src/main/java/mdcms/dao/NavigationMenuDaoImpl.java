package mdcms.dao;

import mdcms.model.NavigationMenu;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("navigationMenuDao")
public class NavigationMenuDaoImpl implements NavigationMenuDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addNav(NavigationMenu nav) {
        sessionFactory.getCurrentSession().saveOrUpdate(nav);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NavigationMenu> getNavs() {
        return (List<NavigationMenu>) sessionFactory.getCurrentSession().createCriteria(NavigationMenu.class).addOrder(Order.asc("order")).list();
    }

    @Override
    public NavigationMenu getNav(int id) {
        return (NavigationMenu) sessionFactory.getCurrentSession().get(NavigationMenu.class, id);
    }

    @Override
    public void deleteNav(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM NAVIGATION_MENU WHERE id = "+id).executeUpdate();
    }
}

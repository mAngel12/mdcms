package mdcms.dao;


import mdcms.model.Contact;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addContactPost(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contact> getContactPosts() {
        return (List<Contact>) sessionFactory.getCurrentSession().createCriteria(Contact.class).addOrder(Order.desc("date")).addOrder(Order.desc("id")).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contact> getContactPostsNotReaded() {
        return (List<Contact>) sessionFactory.getCurrentSession().createCriteria(Contact.class).add(Restrictions.like("readed", "0")).addOrder(Order.desc("date")).addOrder(Order.desc("id")).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contact> getContactPostsReaded() {
        return (List<Contact>) sessionFactory.getCurrentSession().createCriteria(Contact.class).add(Restrictions.like("readed", "1")).addOrder(Order.desc("date")).addOrder(Order.desc("id")).list();
    }

    @Override
    public Contact getContactPost(int id) {
        return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
    }

    @Override
    public void readContactPost(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("UPDATE CONTACT SET readed = 1 WHERE id ="+id).executeUpdate();
    }

    @Override
    public void notReadContactPost(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("UPDATE CONTACT SET readed = 0 WHERE id ="+id).executeUpdate();
    }

    @Override
    public void deleteContactPost(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM CONTACT WHERE id = "+id).executeUpdate();
    }
}

package mdcms.dao;

import mdcms.model.Gallery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("galleryDao")
public class GalleryDaoImpl implements GalleryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addImage(Gallery image) {
        sessionFactory.getCurrentSession().saveOrUpdate(image);
    }

    @Override
    public List<Gallery> getGallery() {
        return (List<Gallery>) sessionFactory.getCurrentSession().createCriteria(Gallery.class).addOrder(Order.desc("date")).addOrder(Order.desc("id")).list();
    }

    @Override
    public Gallery getImage(int id) {
        return (Gallery) sessionFactory.getCurrentSession().get(Gallery.class, id);
    }

    @Override
    public void deleteImage(int id) {
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM GALLERY WHERE id = "+id).executeUpdate();
    }
}

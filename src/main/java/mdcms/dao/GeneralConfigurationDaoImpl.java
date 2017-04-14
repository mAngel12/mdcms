package mdcms.dao;

import mdcms.model.GeneralConfiguration;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("configDao")
public class GeneralConfigurationDaoImpl implements GeneralConfigurationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public GeneralConfiguration getConfig() {
        return (GeneralConfiguration) sessionFactory.getCurrentSession().get(GeneralConfiguration.class, 1);
    }

    @Override
    public void saveConfig(GeneralConfiguration config) {
        sessionFactory.getCurrentSession().saveOrUpdate(config);
    }
}

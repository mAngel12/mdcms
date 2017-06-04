package mdcms.dao;


import mdcms.model.Settings;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("settingsDao")
public class SettingsDaoImpl implements SettingsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Settings getSettings() {
        return (Settings) sessionFactory.getCurrentSession().get(Settings.class, 1);
    }

    @Override
    public void saveSettings(Settings settings) {
        sessionFactory.getCurrentSession().saveOrUpdate(settings);
    }

}

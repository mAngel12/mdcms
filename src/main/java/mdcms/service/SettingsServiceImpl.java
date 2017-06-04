package mdcms.service;


import mdcms.dao.SettingsDao;
import mdcms.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("settingsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SettingsServiceImpl implements SettingsService {

    @Autowired
    private SettingsDao settingsDao;

    @Override
    public Settings getSettings() {
        return settingsDao.getSettings();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void saveSettings(Settings settings) {
        settingsDao.saveSettings(settings);
    }
}

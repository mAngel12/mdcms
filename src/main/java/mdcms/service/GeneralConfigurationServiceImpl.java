package mdcms.service;

import mdcms.dao.GeneralConfigurationDao;
import mdcms.model.GeneralConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("configService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GeneralConfigurationServiceImpl implements GeneralConfigurationService {

    @Autowired
    private GeneralConfigurationDao generalConfigurationDao;

    @Override
    public GeneralConfiguration getConfig() {
        return generalConfigurationDao.getConfig();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void saveConfig(GeneralConfiguration config) {
        generalConfigurationDao.saveConfig(config);
    }
}

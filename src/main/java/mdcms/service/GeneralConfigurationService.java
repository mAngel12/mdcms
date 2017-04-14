package mdcms.service;

import mdcms.model.GeneralConfiguration;

public interface GeneralConfigurationService {

    GeneralConfiguration getConfig();

    void saveConfig(GeneralConfiguration config);
}

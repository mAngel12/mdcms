package mdcms.dao;


import mdcms.model.GeneralConfiguration;

public interface GeneralConfigurationDao {

    GeneralConfiguration getConfig();

    void saveConfig(GeneralConfiguration config);

}

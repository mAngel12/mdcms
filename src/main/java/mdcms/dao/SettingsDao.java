package mdcms.dao;


import mdcms.model.Settings;

public interface SettingsDao {

    Settings getSettings();
    void saveSettings(Settings settings);

}

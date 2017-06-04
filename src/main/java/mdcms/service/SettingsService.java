package mdcms.service;


import mdcms.model.Settings;

public interface SettingsService {

    Settings getSettings();
    void saveSettings(Settings settings);

}

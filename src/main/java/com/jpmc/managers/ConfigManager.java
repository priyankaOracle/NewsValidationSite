package com.jpmc.managers;

import com.jpmc.dataproviders.ConfigFileReader;

public class ConfigManager {

    private static final ConfigManager fileReaderManager = new ConfigManager();
    private static ConfigFileReader configFileReader;

    private ConfigManager() {}

    public static ConfigManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigFileReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }
}

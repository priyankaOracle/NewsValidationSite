package com.jpmc.dataproviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.jpmc.constants.BrowserConstants;
import com.jpmc.constants.ConfigFileConstants;
import com.jpmc.enums.DriverType;
import com.jpmc.enums.ExecutionMode;
import com.jpmc.exceptions.InvalidConfigurationException;
import com.jpmc.exceptions.NewsValidationIOException;
import com.jpmc.exceptions.NewsValidationRuntimeException;

public class ConfigFileReader {

	
	private static final String EXECUTION_MODE_KEY_IN_CONFIGURATION_FILE_IS_NOT_MATCHED = "Execution mode key in configuration file is not matched: ";
	private static final String BROWSER_NAME_KEY_VALUE_IN_CONFIGURATION_FILE_IS_NOT_MATCHED = "Browser name key value in configuration file is not matched: ";
	private static final String TIMEOUT_NOT_SPECIFIED_IN_THE_CONFIG_FILE = "timeout not specified in the config file.";
	private static final String URL_NOT_SPECIFIED_IN_THE_CONFIG_FILE = "url not specified in the config file.";
	private static final String CONFIGURATION_PROPERTIES_NOT_FOUND_AT = "configuration.properties not found at ";
	private static final String UNABLE_TO_LOAD_THE_CONFIGURATION_FILE = "Unable to load the configuration file";
	private final Properties properties;

	public ConfigFileReader() {
		BufferedReader bufferedReader;
		FileReader fileReader;

		try {
			fileReader = new FileReader(ConfigFileConstants.CONFIG_FILE_PATH);
			bufferedReader = new BufferedReader(fileReader);
			properties = new Properties();

			try {
				properties.load(bufferedReader);
				bufferedReader.close();
			} catch (IOException e) {

				throw new NewsValidationIOException(UNABLE_TO_LOAD_THE_CONFIGURATION_FILE, e);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new NewsValidationRuntimeException(CONFIGURATION_PROPERTIES_NOT_FOUND_AT + ConfigFileConstants.CONFIG_FILE_PATH);
		}
	}

	public String getUrl() {
		String url = properties.getProperty(ConfigFileConstants.URL);

		if (url != null)
			return url;
		else
			throw new InvalidConfigurationException(URL_NOT_SPECIFIED_IN_THE_CONFIG_FILE);
	}

	public long getTime() {
		String timeout = properties.getProperty(ConfigFileConstants.TIMEOUT);

		if (timeout != null) {
			return Long.parseLong(timeout);
		} else {
			throw new InvalidConfigurationException(TIMEOUT_NOT_SPECIFIED_IN_THE_CONFIG_FILE);
		}
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty(ConfigFileConstants.BROWSER);

		switch (browserName) {
		case BrowserConstants.CHROME:
			return DriverType.CHROME;
		case BrowserConstants.FIREFOX:
			return DriverType.FIREFOX;
		default:
			throw new InvalidConfigurationException(
					BROWSER_NAME_KEY_VALUE_IN_CONFIGURATION_FILE_IS_NOT_MATCHED + browserName);
		}
	}

	public ExecutionMode getEnvironment() {
		String environmentName = properties.getProperty(ConfigFileConstants.EXECUTION_MODE);

		switch (environmentName) {
		case ConfigFileConstants.LOCAL:
			return ExecutionMode.LOCAL;
		case ConfigFileConstants.PIPELINE:
			return ExecutionMode.PIPELINE;
		default:
			throw new InvalidConfigurationException(
					EXECUTION_MODE_KEY_IN_CONFIGURATION_FILE_IS_NOT_MATCHED + environmentName);
		}
	}
}

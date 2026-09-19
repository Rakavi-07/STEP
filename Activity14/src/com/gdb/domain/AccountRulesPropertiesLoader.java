package com.gdb.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class AccountRulesPropertiesLoader {

    private Properties properties = new Properties();

    public AccountRulesPropertiesLoader(String configPath) {
        loadProperties(configPath);
    }

    private void loadProperties(String configPath) {

        InputStream input = null;

        try {
            // Try loading from classpath first
            input = getClass().getClassLoader()
                    .getResourceAsStream(configPath);

            // If not found, try loading from file path
            if (input == null) {

                File file = new File(configPath);

                if (file.exists()) {
                    input = new FileInputStream(file);
                }
            }

            // If file was not found
            if (input == null) {
                System.out.println(
                    "[Config] Warning: Could not find " + configPath
                );
                return;
            }

            properties.load(input);

        } catch (Exception e) {

            System.out.println(
                "[Config] Warning: Could not load " + configPath
            );

        } finally {

            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    // Ignore close exception
                }
            }
        }
    }

    public String getProperty(String key, String defaultValue) {

        return properties.getProperty(key, defaultValue);
    }

    public double getDouble(String key, double defaultValue) {

        String value = properties.getProperty(key);

        if (value == null) {
            return defaultValue;
        }

        try {
            return Double.parseDouble(value.trim());

        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public int getInt(String key, int defaultValue) {

        String value = properties.getProperty(key);

        if (value == null) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value.trim());

        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
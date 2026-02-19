package com.delivery;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

public class TariffLoader {

    public static Tariff load(String fileName) {
        Yaml yaml = new Yaml();
        InputStream input = TariffLoader.class
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (input == null) {
            throw new RuntimeException("YAML not found");
        }

        return yaml.loadAs(input, Tariff.class);
    }
}

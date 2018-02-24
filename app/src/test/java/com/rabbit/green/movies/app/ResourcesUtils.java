package com.rabbit.green.movies.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class ResourcesUtils {
    static String jsonFileToString(String name) throws IOException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        File file = new File(loader.getResource(name).getFile());
        byte[] json = Files.readAllBytes(file.toPath());
        return new String(json);
    }
}

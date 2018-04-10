package com.github.sebastianek12345.controller;

import com.github.sebastianek12345.model.PasswordEntry;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PasswordSafeController {

    List<String> gson;

    public void saveToFile(List<PasswordEntry> passwordEntries) {

        Gson gson = new Gson();
        List<String> jsons = passwordEntries.stream()
                .map(gson::toJson)
                .collect(Collectors.toList());

        File file = new File("password-manager-file.pwm");
        try {
            FileUtils.writeLines(file, jsons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection<PasswordEntry> readFromFile(String readFile) {

        Gson gson = new Gson();

        File file = new File(readFile);
        try {
            return FileUtils.readLines(file, "UTF-8").stream()
                    .map(s -> gson.fromJson(s, PasswordEntry.class))
                    .collect(Collectors.toSet());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptySet();
    }
}

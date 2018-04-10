package com.github.sebastianek12345.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PasswordSafe {

    private Map<Integer, PasswordEntry> passwordEntries = new HashMap<>();
    private Integer nextId = 0;

    public void addEntries(String service, String login, String password) {
        Integer id = nextId++;
        PasswordEntry passwordEntry = new PasswordEntry(id, password, login, service);
        passwordEntries.put(passwordEntry.getId(), passwordEntry);
    }

    public void removeEntries(Integer id) {
        passwordEntries.remove(id);
    }


    public String show(String service) {
        for (PasswordEntry passwordEntry : passwordEntries.values()) {
            if (passwordEntry.getServiceName().equals(service)) {
                return passwordEntry.getPasswordName();
            }
        }
        return null;
    }
}
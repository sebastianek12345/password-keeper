package com.github.sebastianek12345.model;

import java.util.*;

public class PasswordSafe {

    private Map<Integer, PasswordEntry> entries = new HashMap<>();
    private Integer nextId = 0;

    public PasswordSafe() {

    }

    public PasswordSafe(Collection<PasswordEntry> passwordEntries) {
        passwordEntries.forEach(passwordEntry -> entries.put(passwordEntry.getId(), passwordEntry));
        nextId = entries.values().stream()
                .mapToInt(PasswordEntry::getId)
                .max()
                .orElse(0) + 1;
    }

    public Collection<PasswordEntry> all() {
        return entries.values();
    }

    public PasswordEntry addEntries(String service, String login, String password) {

        Integer id = nextId++;
        PasswordEntry passwordEntry = new PasswordEntry(id, password, login, service);
        entries.put(passwordEntry.getId(), PasswordEntry.Builder.create().withId(nextId)
                .withPassword(password)
                .withLogin(login)
                .withService(service)
                .build());

        return passwordEntry;
    }

    public void removeEntries(Integer id) {
        entries.remove(id);

    }


    public String show(String service) {
        for (PasswordEntry passwordEntry : entries.values()) {
            if (passwordEntry.getServiceName().equals(service)) {
                return passwordEntry.getPasswordName();

            }
        }
        return null;
    }

    public boolean exists(String aSuper, String duper) {
        return entries.values().stream()
                .anyMatch(e -> e.getServiceName().equals(aSuper) && e.getLogin().equals(duper));
    }
}
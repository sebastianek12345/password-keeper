package com.github.sebastianek12345.model;

import java.util.Objects;

public class PasswordEntry {

    private Integer id;
    private String passwordName;
    private String login;
    private String serviceName;

    public PasswordEntry(Integer id, String passwordName, String login, String serviceName) {
        this.id = id;
        this.passwordName = passwordName;
        this.login = login;
        this.serviceName = serviceName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPasswordName() {
        return passwordName;
    }

    public void setPasswordName(String passwordName) {
        this.passwordName = passwordName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordEntry that = (PasswordEntry) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(passwordName, that.passwordName) &&
                Objects.equals(login, that.login) &&
                Objects.equals(serviceName, that.serviceName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, passwordName, login, serviceName);
    }

    @Override
    public String toString() {
        return "PasswordEntry{" +
                "id=" + id +
                ", passwordName='" + passwordName + '\'' +
                ", login='" + login + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}

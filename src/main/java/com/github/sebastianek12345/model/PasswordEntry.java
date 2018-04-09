package com.github.sebastianek12345.model;

public class PasswordEntry {

    private Integer Id;
    private String passwordName;
    private String login;
    private String serviceName;

    public PasswordEntry(Integer id, String passwordName, String login, String serviceName) {
        Id = id;
        this.passwordName = passwordName;
        this.login = login;
        this.serviceName = serviceName;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
}

package com.r13a.copilot.model;

import java.io.Serializable;

public class User implements Serializable {

    private String email;
    private String userId;
    private Boolean active;

    public User(String email, String userId, Boolean active) {
        this.email = email;
        this.userId = userId;
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getActive() {
        return active;
    }

    public boolean isActive() {
        return active.booleanValue();
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

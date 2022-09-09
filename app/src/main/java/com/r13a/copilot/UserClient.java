package com.r13a.copilot;

import android.app.Application;

import com.r13a.copilot.model.User;


public class UserClient extends Application {

    private User user = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

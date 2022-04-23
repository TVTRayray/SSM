package org.example.domain;

import java.util.List;


public class Vo {
    private List<User> userList;

    @Override
    public String toString() {
        return "Vo{" +
                "userList=" + userList +
                '}';
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

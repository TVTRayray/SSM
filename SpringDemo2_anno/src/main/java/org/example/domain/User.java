package org.example.domain;

public class User {
    private String name;
    private String add;
    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", add='" + add + '\'' +
                '}';
    }
}


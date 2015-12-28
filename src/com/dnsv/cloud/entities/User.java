package com.dnsv.cloud.entities;

public class User {
    public enum Entity {STUDENT, TEACHER}

    int id;
    String name;
    String password;
    Entity entity;

    public User(int id, String name, String password, Entity entity) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.entity = entity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!name.equals(user.name)) return false;
        if (!password.equals(user.password)) return false;
        return entity == user.entity;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + entity.hashCode();
        return result;
    }
}

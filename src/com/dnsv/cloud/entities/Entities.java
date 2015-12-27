package com.dnsv.cloud.entities;

public class Entities {
    public enum Entity {STUDENT, TEACHER}

    int id;
    String name;
    String password;
    Entity entity;

    public Entities(int id, String name, String password, Entity entity) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.entity = entity;
    }
}

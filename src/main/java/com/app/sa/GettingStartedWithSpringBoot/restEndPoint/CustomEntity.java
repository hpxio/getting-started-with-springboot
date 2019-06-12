package com.app.sa.GettingStartedWithSpringBoot.restEndPoint;

import org.springframework.stereotype.Component;

@Component
public class CustomEntity {
    public CustomEntity() {
    }

    public CustomEntity(String name, String data) {
        this.name = name;
        this.data = data;
    }

    private String name;

    private String data;

    @Override
    public String toString() {
        return "CustomEntity [data=" + data + ", name=" + name + "]";
    }

}
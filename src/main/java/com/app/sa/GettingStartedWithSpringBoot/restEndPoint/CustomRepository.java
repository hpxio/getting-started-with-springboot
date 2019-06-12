package com.app.sa.GettingStartedWithSpringBoot.restEndPoint;

import java.util.HashSet;
import java.util.Set;


import org.springframework.stereotype.Repository;


@Repository
public class CustomRepository {
    private Set<CustomEntity> col = new HashSet<>();

    public void save(String name, String data) {
        col.add(new CustomEntity(name, data));
    }

    public String print() {
        return col.toString();
    }
}
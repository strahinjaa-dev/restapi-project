package org.example.controller;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Special-Projects-001 on 20/03/2019.
 */

public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet resources = new HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.example.controllers.InstructorController.class);


    }
}
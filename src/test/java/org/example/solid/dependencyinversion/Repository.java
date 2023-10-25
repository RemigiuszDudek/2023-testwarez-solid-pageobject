package org.example.solid.dependencyinversion;

public interface Repository {
    Entity getById(String id);

    void save(Entity entity);
}

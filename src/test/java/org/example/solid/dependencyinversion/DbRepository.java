package org.example.solid.dependencyinversion;

public class DbRepository implements Repository {
    @Override
    public Entity getById(String id) {
        return null;
    }

    @Override
    public void save(Entity entity) {

    }
}

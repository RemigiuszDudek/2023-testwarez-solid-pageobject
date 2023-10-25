package org.example.solid.dependencyinversion;

public class AppService {
    private final Repository repository;

    public AppService(Repository repository) {
        this.repository = repository;
    }
}

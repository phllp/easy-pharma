package org.ws_solutions.model;

public class Administrador extends Usuario {
    private String id;

    public Administrador() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}

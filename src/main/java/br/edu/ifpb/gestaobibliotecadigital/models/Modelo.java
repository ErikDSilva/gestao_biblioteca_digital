package br.edu.ifpb.gestaobibliotecadigital.models;

import java.io.Serializable;
import java.util.UUID;

public abstract class Modelo implements Serializable {

    protected final UUID id;

    public Modelo() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}

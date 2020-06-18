package com.example.pokedemo.model;

import com.example.pokedemo.model.resource.ApiResource;
import com.example.pokedemo.model.resource.NamedApiResource;
import com.example.pokedemo.service.ApiResourceVisitor;

import java.util.Collections;
import java.util.List;

public class Ability extends NamedApiResource {

    private int id;

    @Override
    public List<ApiResource> getDependencies() {
        return Collections.emptyList();
    }

    @Override
    public void accept(ApiResourceVisitor visitor) {
        visitor.visit(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "name='" + this.getName() +
                "}";
    }
}

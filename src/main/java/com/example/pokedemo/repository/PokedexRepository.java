package com.example.pokedemo.repository;

import java.util.List;

public interface PokedexRepository<T> {

    List<T> getByPage(int limit, int offset);

    T getByName(String name);
}

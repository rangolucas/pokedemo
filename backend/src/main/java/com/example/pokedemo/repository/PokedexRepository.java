package com.example.pokedemo.repository;

import com.example.pokedemo.model.Page;

import java.util.List;

public interface PokedexRepository<T> {

    List<T> getByPage(Page page);

    T getByUrl(String url);
}

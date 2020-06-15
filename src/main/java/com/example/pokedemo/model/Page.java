package com.example.pokedemo.model;

import com.example.pokedemo.AppConfig;
import com.example.pokedemo.SpringContext;
import com.example.pokedemo.exception.PokedexException;

import java.util.Objects;

public class Page {
    private final int pageNumber;
    private final int pageSize;
    private final int offset;

    public Page(int pageNumber) throws PokedexException {
        if(pageNumber <= 0) {
            throw new PokedexException("Invalid page number");
        }

        this.pageSize = SpringContext.getBean(AppConfig.class).getPageSize();
        this.pageNumber = pageNumber;
        this.offset = this.pageSize * (pageNumber - 1);
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getOffset() {
        return this.offset;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNumber=" + pageNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return pageNumber == page.pageNumber &&
                pageSize == page.pageSize &&
                offset == page.offset;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNumber, pageSize, offset);
    }
}

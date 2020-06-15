package com.example.pokedemo.model.resource;

import java.net.URL;
import java.util.List;

public class ApiResourceList {

    private int count;
    private URL next;
    private URL previous;
    private List<ApiResource> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public URL getNext() {
        return next;
    }

    public void setNext(URL next) {
        this.next = next;
    }

    public URL getPrevious() {
        return previous;
    }

    public void setPrevious(URL previous) {
        this.previous = previous;
    }

    public List<ApiResource> getResults() {
        return results;
    }

    public void setResults(List<ApiResource> results) {
        this.results = results;
    }
}

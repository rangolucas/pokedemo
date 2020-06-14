package com.example.pokedemo.client;

import java.net.URL;
import java.util.List;

public class NamedApiResourceList {

    private int count;
    private URL next;
    private URL previous;
    private List<NamedApiResource> results;

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

    public List<NamedApiResource> getResults() {
        return results;
    }

    public void setResults(List<NamedApiResource> results) {
        this.results = results;
    }
}

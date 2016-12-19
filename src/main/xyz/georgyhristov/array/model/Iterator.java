package main.xyz.georgyhristov.array.model;

import main.xyz.georgyhristov.array.exception.IteratorOutOfBoundsException;

/**
 * Created by gohv on 17.12.16.
 */
public interface Iterator {

    public void previous() throws UnsupportedOperationException;
    public boolean isDone()throws UnsupportedOperationException;
    public Object current() throws IteratorOutOfBoundsException;
    public void first()throws UnsupportedOperationException;
    public void next()throws UnsupportedOperationException;
    public void last()throws UnsupportedOperationException;

}

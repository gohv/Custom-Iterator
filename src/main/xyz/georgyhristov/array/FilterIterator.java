package main.xyz.georgyhristov.array;

import main.xyz.georgyhristov.array.exception.IteratorOutOfBoundsException;
import main.xyz.georgyhristov.array.model.Iterator;
import main.xyz.georgyhristov.array.model.Predicate;

/**
 * Created by gohv on 19.12.16.
 */
public class FilterIterator implements Iterator {
    private final Iterator iterator;
    private final Predicate predicate;

    public FilterIterator(Iterator iterator, Predicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }


    @Override
    public boolean isDone() throws UnsupportedOperationException {
        return iterator.isDone();
    }

    @Override
    public Object current() throws IteratorOutOfBoundsException {
        return iterator.current();
    }

    @Override
    public void first() throws UnsupportedOperationException {
        iterator.first();
        filterForwards();
    }


    @Override
    public void next() throws UnsupportedOperationException {
        iterator.next();
        filterForwards();
    }

    @Override
    public void last() throws UnsupportedOperationException {
        iterator.last();
        filterBackwards();
    }

    @Override
    public void previous() throws UnsupportedOperationException {
        iterator.previous();
        filterBackwards();
    }


    private void filterForwards() {
        while (!iterator.isDone() && predicate.evaluate(iterator.current())){
            iterator.next();
        }
    }
    private void filterBackwards() {
        while (!iterator.isDone() && predicate.evaluate(iterator.current())){
            iterator.previous();
        }
    }
}

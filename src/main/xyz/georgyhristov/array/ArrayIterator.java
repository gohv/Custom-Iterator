package main.xyz.georgyhristov.array;

import main.xyz.georgyhristov.array.exception.IteratorOutOfBoundsException;
/**
 * Created by gohv on 17.12.16.
 */
public class ArrayIterator implements main.xyz.georgyhristov.array.model.Iterator{

    private final Object[] array;
    private final int start;
    private int current = -1;
    private final int last;

    //iterate parts of the array
    public ArrayIterator(Object[] array, int start, int length) {

        assert array != null : "array cant be null";
        assert start >= 0 : "start cant be < 0";
        assert start < array.length : "start cannot be > array.length";
        assert length >= 0 : "length < 0";

        this.array = array;
        this.start = start;
        this.last = start + length -1;
    }
    //iterate the whole array
    public ArrayIterator(Object[] array) {
        assert array != null : "array cannot be null";
        this.array = array;
        start = 0;
        last = array.length -1;
    }
    public void first(){
        current = start;
    }

    public void last(){
        current = last;
    }

    public void next(){
        ++current;

    }
    public void previous(){
        current--;

    }


    public boolean hasNext() {
        return false;
    }

    public boolean isDone(){
            return current < start || current > last;
    }

    public void remove() {
    }

    public Object current() throws IteratorOutOfBoundsException{
        if(isDone()){
            throw new IteratorOutOfBoundsException("Eba li go");
        }
        return array[current];
    }



}

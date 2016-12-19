package test.xyz.georgyhristov.array;

import junit.framework.TestCase;
import main.xyz.georgyhristov.array.ArrayIterator;

/**
 * Created by gohv on 17.12.16.
 */
public class ArrayIteratorTest extends TestCase {

    Object[] array = {"A","B","C","D","E","F","F"};
    ArrayIterator iterator = new ArrayIterator(array,0,array.length -1);
    ArrayIterator wholeArray = new ArrayIterator(array);

    public void testIterator(){
        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(array[0],iterator.current());

        wholeArray.first();
        wholeArray.next();
        wholeArray.next();
        wholeArray.next();
        assertFalse(wholeArray.isDone());
        assertSame(array[3],wholeArray.current());
    }





}

package test.xyz.georgyhristov.array;

import junit.framework.TestCase;
import main.xyz.georgyhristov.array.ArrayIterator;
import main.xyz.georgyhristov.array.FilterIterator;
import main.xyz.georgyhristov.array.exception.IteratorOutOfBoundsException;
import main.xyz.georgyhristov.array.model.Iterator;
import main.xyz.georgyhristov.array.model.Predicate;

/**
 * Created by gohv on 19.12.16.
 */
public class FilterIteratorTestCase extends TestCase {
   
    Object[] array = {"A","B","C","D","E","F","F"};

    private static final class DummyPredicate implements Predicate{
        private final Iterator iterator;
        private final boolean result;

        public DummyPredicate(Iterator iterator, boolean result) {
            this.iterator = iterator;
            this.result = result;
            iterator.first();

        }

        @Override
        public boolean evaluate(Object object) {
            assertSame(iterator.current(),object);
            iterator.next();
            return result;
        }
    }

    public void testForward(){
        Iterator expectedIterator = new ArrayIterator(array);
        Iterator underlyingIterator = new ArrayIterator(array);

        Iterator iterator = new FilterIterator(underlyingIterator
                ,new DummyPredicate(expectedIterator,true));

        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(array[0],iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(array[1],iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(array[2],iterator.current());

        iterator.next();
        assertTrue(iterator.isDone());
        try{
            iterator.current();
            fail();
        }catch (IteratorOutOfBoundsException e){
            System.out.println("Expected " + array[3]);
        }

        assertTrue(expectedIterator.isDone());
        assertTrue(underlyingIterator.isDone());
    }

    public void testForwardWhenFalse(){
        Iterator expectedIterator = new ArrayIterator(array);
        Iterator underlyingIterator = new ArrayIterator(array);

        Iterator iterator = new FilterIterator(underlyingIterator
                ,new DummyPredicate(expectedIterator,false));

        iterator.first();
        assertTrue(iterator.isDone());
        try{
            iterator.current();
            fail();
        }catch (IteratorOutOfBoundsException e){
            e.printStackTrace();
        }

        assertTrue(expectedIterator.isDone());
        assertTrue(underlyingIterator.isDone());
    }

}

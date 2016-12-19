package main.xyz.georgyhristov.array.model;

/**
 * Created by gohv on 19.12.16.
 *
 * Contains only one method - evaluate.
 * evaluate is called for each value and evaluates if the value
 * is true to the given criteria
 *
 */
public interface Predicate {

    public boolean evaluate(Object object);


}

package ua.edu.ucu.stream.iterator;

import java.util.Iterator;

abstract class AbstractDecorator implements Iterator<Integer>{

    protected Iterator<Integer> iter;

    public AbstractDecorator(Iterator<Integer> iter){
        this.iter = iter;
    }

}

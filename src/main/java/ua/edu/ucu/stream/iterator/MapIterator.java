package ua.edu.ucu.stream.iterator;

import ua.edu.ucu.function.IntUnaryOperator;

import java.util.Iterator;

public class MapIterator extends AbstractDecorator{

    private IntUnaryOperator mapper;

    public MapIterator(Iterator<Integer> iter, IntUnaryOperator mapper) {
        super(iter);
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return this.iter.hasNext();
    }

    @Override
    public Integer next() {
        return this.mapper.apply(this.iter.next());
    }
}

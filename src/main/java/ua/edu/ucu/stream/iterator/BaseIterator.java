package ua.edu.ucu.stream.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BaseIterator implements Iterator<Integer> {

    private int[] arr;
    private int i;

    public BaseIterator(int... arr){
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return i != arr.length;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()){
            throw new NoSuchElementException();
        }
        return arr[i++];
    }
}

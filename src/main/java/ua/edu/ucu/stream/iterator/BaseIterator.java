package ua.edu.ucu.stream.iterator;

import java.util.Iterator;

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
        return arr[i++];
    }
}

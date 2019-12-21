package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.stream.iterator.BaseIterator;
import ua.edu.ucu.stream.iterator.FilterIterator;
import ua.edu.ucu.stream.iterator.FlatMapIterator;
import ua.edu.ucu.stream.iterator.MapIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class AsIntStream implements IntStream {

    private Iterator<Integer> iterator;

    private AsIntStream(Iterator<Integer> iterator){
        this.iterator = iterator;
    }

    private AsIntStream(int... values) {
        this.iterator = new BaseIterator(values);
    }

    public static IntStream of(int... values) {
        return new AsIntStream(values);
    }

    private Iterable<Integer> iter() {
        return () -> this.iterator;
    }

    private void checkIsEmpty(){
        if (!this.iterator.hasNext()){
            throw new IllegalArgumentException();
        }
    }

    public Iterator<Integer> getIterator(){
        return this.iterator;
    }

    @Override
    public Double average() {
        this.checkIsEmpty();
        double sum = 0.0;
        long num = 0;
        for (int i: this.iter()) {
            sum += i;
            num += 1;
        }
        return sum/num;
    }

    @Override
    public Integer max() {
        this.checkIsEmpty();
        return reduce(Integer.MIN_VALUE, Integer::max);
    }

    @Override
    public Integer min() {
        this.checkIsEmpty();
        return reduce(Integer.MAX_VALUE, Integer::min);
    }

    @Override
    public long count() {
        return reduce(0, (x, y) -> x + 1);
    }

    @Override
    public Integer sum() {
        this.checkIsEmpty();
        return reduce(0, Integer::sum);
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        return new AsIntStream(new FilterIterator(this.iterator, predicate));
    }

    @Override
    public void forEach(IntConsumer action) {
        for (int i: this.iter()) {
            action.accept(i);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        return new AsIntStream(new MapIterator(this.iterator, mapper));
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        return new AsIntStream(new FlatMapIterator(this.iterator, func));
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int ans = identity;
        for (int i: this.iter()) {
            ans = op.apply(ans, i);
        }
        return ans;
    }

    @Override
    public int[] toArray() {
        ArrayList<Integer> arrl = new ArrayList<>();
        for (int i: this.iter()) {
            arrl.add(i);
        }
        int l = arrl.size();
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = arrl.get(i);
        }
        return arr;
    }

}

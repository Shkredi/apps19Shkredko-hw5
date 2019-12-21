package ua.edu.ucu.stream.iterator;

import ua.edu.ucu.function.IntPredicate;

import java.util.Iterator;

public class FilterIterator extends AbstractDecorator {

    private IntPredicate predicate;
    private Integer val;

    public FilterIterator(Iterator<Integer> iter, IntPredicate predicate) {
        super(iter);
        this.predicate = predicate;
        this.val = getNext();
    }

    @Override
    public boolean hasNext() {
        return !(val == null);
    }

    private Integer getNext(){
        int res;
        do{
            if (!this.iter.hasNext()){
                return null;
            }
            res = this.iter.next();
        }while (!this.predicate.test(res));

        return res;
    }

    @Override
    public Integer next() {
        int res = val;
        val = getNext();
        return res;
    }
}

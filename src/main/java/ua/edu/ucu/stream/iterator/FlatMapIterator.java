package ua.edu.ucu.stream.iterator;

import ua.edu.ucu.function.IntToIntStreamFunction;
import ua.edu.ucu.stream.AsIntStream;

import java.util.Iterator;

public class FlatMapIterator extends AbstractDecorator {

    private IntToIntStreamFunction func;
    private Iterator<Integer> cur;
    private Integer val;

    public FlatMapIterator(Iterator<Integer> iter, IntToIntStreamFunction func) {
        super(iter);
        this.func = func;
        if (this.iter.hasNext()){
            this.cur = this.getIter(this.iter.next());
            this.val = this.getNext();
        }
        else {
            this.val = null;
        }
    }

    private Iterator<Integer> getIter(int val){
        return ((AsIntStream)func.applyAsIntStream(val)).getIterator();
    }

    private Integer getNext() {
        if (this.cur.hasNext()){
            return this.cur.next();
        }

       do{
            if (!this.iter.hasNext()){
                return null;
            }
            this.cur = this.getIter(this.iter.next());
        } while (!this.cur.hasNext());

        return this.cur.next();
    }

    @Override
    public boolean hasNext() {
        return !(this.val == null);
    }

    @Override
    public Integer next() {
        int res = this.val;
        this.val = this.getNext();
        return res;
    }
}

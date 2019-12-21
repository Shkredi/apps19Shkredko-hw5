package ua.edu.ucu.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class AsIntStreamTest {

    private IntStream stream;
    private IntStream nullStream;

    @Before
    public void setUp() throws Exception {
        this.stream = AsIntStream.of(1,2,3,4,5);
        this.nullStream = AsIntStream.of();
    }

    @Test
    public void average() {
        assertEquals(3.0, this.stream.average(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullAverage(){
        this.nullStream.average();
    }

    @Test
    public void max() {
        assertEquals(new Integer(5), this.stream.max());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullMax(){
        this.nullStream.max();
    }

    @Test
    public void min() {
        assertEquals(new Integer(1), this.stream.min());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullMin(){
        this.nullStream.min();
    }

    @Test
    public void count() {
        assertEquals(5, this.stream.count());
    }

    @Test
    public void sum() {
        assertEquals(new Integer(15), this.stream.sum());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullSum(){
        this.nullStream.sum();
    }

    @Test
    public void filter() {
        assertArrayEquals(new int[] {1, 3, 5}, this.stream.filter(x -> x%2 == 1).toArray());
    }

    @Test
    public void nullFilter() {
        assertArrayEquals(new int[] {}, this.nullStream.filter(x -> x%2 == 1).toArray());
    }

    @Test
    public void forEach() {
        StringBuilder str = new StringBuilder();
        this.stream.forEach(str::append);
        assertEquals("12345", str.toString());
    }

    @Test
    public void nullForEach() {
        StringBuilder str = new StringBuilder();
        this.nullStream.forEach(str::append);
        assertEquals("", str.toString());
    }

    @Test
    public void map() {
        assertArrayEquals(new int[] {2,4,6,8,10}, this.stream.map(x -> 2*x).toArray());
    }

    @Test
    public void nullMap() {
        assertArrayEquals(new int[] {}, this.nullStream.map(x -> 2*x).toArray());
    }

    @Test
    public void flatMap() {
        assertArrayEquals(new int[] {2,4,6,8,10}, this.stream.flatMap(x -> AsIntStream.of(2*x)).toArray());
    }

    @Test
    public void nullFlatMap() {
        assertArrayEquals(new int[] {}, this.nullStream.flatMap(x -> AsIntStream.of()).toArray());
    }

    @Test
    public void reduce() {
        assertEquals(120, this.stream.reduce(1, (x, y) -> x*y));
    }

    @Test
    public void nullReduce() {
        assertEquals(1, this.nullStream.reduce(1, (x, y) -> x*y));
    }

    @Test
    public void toArray() {
        assertArrayEquals(new int[] {1,2,3,4,5}, this.stream.toArray());
    }

    @Test
    public void nullToArray() {
        assertArrayEquals(new int[] {}, this.nullStream.toArray());
    }

    @Test(expected = NoSuchElementException.class)
    public void next(){
        Iterator<Integer> iter = ((AsIntStream)this.stream).getIterator();
        for (int i = 0; i < 10; i++) {
            iter.next();
        }
    }
}
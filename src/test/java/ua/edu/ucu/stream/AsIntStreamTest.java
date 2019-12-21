package ua.edu.ucu.stream;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AsIntStreamTest {

    IntStream stream;
    IntStream nullStream;

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

//    @Test
//    public void filter() {
//    }
//
//    @Test
//    public void forEach() {
//    }
//
//    @Test
//    public void map() {
//    }
//
//    @Test
//    public void flatMap() {
//    }
//
//    @Test
//    public void reduce() {
//    }
//
//    @Test
//    public void toArray() {
//    }
}
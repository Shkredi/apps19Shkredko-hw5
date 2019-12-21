package ua.edu.ucu.stream;

import ua.edu.ucu.function.IntConsumer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(AsIntStream.of(1, 2, 3, 4).toArray()));
//        System.out.println(AsIntStream.of(1, 2, 3, 4).sum());
//        System.out.println(AsIntStream.of(1, 2, 3, 4).max());
//        System.out.println(AsIntStream.of(1, 2, 3, 4).min());
//        System.out.println(AsIntStream.of(1, 2, 3, 4).count());
//        System.out.println(AsIntStream.of(1, 2, 3, 4).average());
//        System.out.println(AsIntStream.of(1, 2, 3, 4).reduce(1, (x, y) -> x*y));
        IntConsumer s = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        };
//        AsIntStream.of(1, 2, 3, 4).forEach(s);


        AsIntStream.of(1, 2, 3, 4).filter(x -> x>2).forEach(s);


    }
}

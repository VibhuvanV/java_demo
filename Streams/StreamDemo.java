package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("mango");
        list.add("pear");
        list.add("peach");

        Stream<String> s = list.stream();
//        list.parallel() - normal stream is converted to parallel stream.
//        s.forEach(e -> System.out.println(e));

        Stream<String> s1 = Stream.of("laptop", "mouse", "keyboard");
        s1.forEach(System.out::println);

        Stream<String> s2 = list.parallelStream();
        s2.forEach(e -> System.out.println(e));

//        Arrays has a static method stream ,
        int[] arr = {10, 9, 8, 7};
        Stream<Integer> num = Arrays.stream(arr).boxed();
        num.forEach(System.out::println);

//        Stream.empty()
//        Stream.generate(new Random()::nextInt).forEach(System.out::println);
//        Stream.iterate(1 , n -> n++);  --> Infinite series of numbers from 1

//        s.map(e -> e.toUpperCase()).map(e -> e.startsWith("P")).forEach(System.out::println);
        s.map(e -> e.toUpperCase()).forEach(System.out::println);

        Stream.generate(new Random()::nextInt).map(e -> e % 10).limit(15).forEach(System.out::println);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Stream<Integer> num_stream = numbers.stream();
        int result = num_stream.reduce(1, (a,b) -> a*b);
        System.out.println(result);

    }
}

package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("India");
        list.add("UAE");
        list.add("Bhutan");
        list.add("Russia");
        list.add("Ireland");
        list.add("Iceland");
        list.add("Indonesia");

        System.out.println(list);
        Stream<String> s = list.stream();
        Stream<String[]> string_array = s.map(e -> e.split(""));
        string_array.forEach(System.out::println);

        string_array.flatMap(Arrays::stream).forEach(System.out::println);

        /** Filter Method in Streams*/
//        s.map(e -> e.toUpperCase()).filter(e -> e.startsWith("I")).forEach(System.out::println);

    }
}

package Optional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> ans = sayHello();
        // isPresent()
        System.out.println("isPresent : " + ans.isPresent());

        // ifPresent()
        ans.ifPresent(value ->
                System.out.println("ifPresent : " + value));

        // ifPresentOrElse()
//        ans.ifPresentOrElse(
//                value -> System.out.println("ifPresentOrElse : " + value),
//                () -> System.out.println("ifPresentOrElse : NULL")
//        );

        // orElse()
        System.out.println("orElse : " + ans.orElse("Default"));

        // orElseGet()
        System.out.println("orElseGet : " +
                ans.orElseGet(() -> "Generated Default"));

        // orElseThrow()
        /*try {
            System.out.println("orElseThrow : " +
                    ans.orElseThrow());
        } catch (Exception e) {
            System.out.println("Exception Thrown");
        }
        */
        // map()
        System.out.println("map : " +
                ans.map(String::toUpperCase)
                        .orElse("NULL"));

        // filter()
        System.out.println("filter : " +
                ans.filter(s -> s.startsWith("H"))
                        .orElse("Not Matched"));

        List<String> countries = Arrays.asList("India", null, "Canada", null, "Brazil", "Rome", null);
        List<String> s = countries.stream()
                .filter(Objects::nonNull)
                .map(e -> e.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(s);
    }

    public static Optional<String> sayHello() {
        String msg = null;
        int num = new Random().nextInt();
        if (num % 2 == 0) {
            msg = "Hello";
        }
        System.out.println("Random Number : " + num);
        return Optional.ofNullable(msg);
    }
}

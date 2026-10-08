package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectAndThenDemo {
    List<Product> list = Arrays.asList(new Product("Apple", 1200), new Product("Samsung", 350),
            new Product("MI", 250), new Product("OnePlus", 260), new Product("Nokia", 200));

    String minPriceProduct = list.stream()
            .collect(Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Product::getCost)),
                    (e -> e.isPresent() ? e.get().getName() : "None")
    ));
}

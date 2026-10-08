package Collections.Lists;

import java.util.*;
import java.util.LinkedList;
import java.util.List;

class CustomSort implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2,o1);
    }

}

class CustomSortString implements Comparator<String> {
    @Override
    public int compare(String o1 , String o2) {
        char w1 = o1.charAt(o1.length() - 1);
        char w2 = o2.charAt(o2.length() -1);
        return Character.compare(w1, w2);
    }
}

public class ListCollections {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<String> linked_list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        System.out.println(list);

        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {
            Integer num = it.next();
            if(num % 2 == 0) {
                it.remove();
            }
        }

        System.out.println(list);
        int num = list.get(2);

        list.set(2, 2);
        for(Integer iter : list) {
            System.out.print(iter + " ");
        }

        System.out.println("\n" + list.size());
        boolean search = list.contains(Integer.valueOf(1));
        System.out.println(search);
        int index = list.indexOf(Integer.valueOf(3));

        System.out.println("===== Linked List Operations");
        linked_list.add("India");
        linked_list.add("USA");
        linked_list.add("China");
        linked_list.add("Russia");
        linked_list.add("Sri Lanka");

        System.out.println(linked_list);
        String first_element = ((LinkedList<String>) linked_list).getFirst();
        String last_element= ((LinkedList<String>) linked_list).getLast();

        System.out.println(first_element+ "\t" + last_element);
        ((LinkedList<String>) linked_list).addFirst("Myanmar");
        ((LinkedList<String>) linked_list).addLast("Bhutan");

        System.out.println(linked_list);

        Collections.sort(linked_list);
        System.out.println(linked_list);
        Collections.sort(linked_list, Comparator.reverseOrder());
        System.out.println(linked_list);

        System.out.println("Custom Sorting : ");
        Collections.sort(list , new CustomSort());
        System.out.println(list);
    }

}

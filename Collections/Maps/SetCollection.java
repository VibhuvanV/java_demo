package Collections.Maps;

import java.util.*;

public class SetCollection {
    public static void main(String[] args){
        Set<Integer> s = new HashSet<>(Arrays.asList(1,1,2,5,5,4,4,7,7,7));
        Set<Integer> s1 = new HashSet<>();
        s1.add(2);
        for(int x : s) {
            System.out.print(x + " ");
        }
        System.out.println();

        Iterator<Integer> iter = s.iterator();
        while(iter.hasNext()) {
            int num = iter.next();
            if((num & 1) == 0) iter.remove();
        }
        for(int it : s) System.out.print(it + " ");
        System.out.println();
        s.add(2);
        for(int n : s) {
            for(int i=2;i*i < n;i++) {
                if(n % i != 0) {
                    s1.add(n);
                }
            }
        }
        for(int it : s1) System.out.print(it + " ");
        System.out.println();
        System.out.println("Union of sets: " );
        s.addAll(s1);
        System.out.println(s);
        System.out.println("Intersection of sets: ");
        s.retainAll(s1);
        System.out.println(s);
        System.out.println("Difference of sets: ");
        s.removeAll(s1);
        System.out.println(s);
        System.out.println("Is subset: " + s1.containsAll(s));
        System.out.println(s.contains(2));

//        Treeset : first() , last() , lower(obj) , higher(obj)
    }
}

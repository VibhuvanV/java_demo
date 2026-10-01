package Collections.Maps;

import java.util.*;
import java.util.List;

public class MapCollection {
    public static void main(String[] args) {
        Map<Integer , List<String>>m = new HashMap<>();
        List<String> list= new ArrayList<>();
        list.addAll(Arrays.asList("India", "Japan", "Bangladesh", "Pakistan", "USA", "UAE", "England", "Russia"));
        for(String it : list) {
            int key = it.length();
            if(!m.containsKey(key)) {
                m.put(key, new ArrayList<>());
            }
            m.get(key).add(it);
        }
        System.out.print("Keys present: ");
        for(int keys : m.keySet()){
            System.out.print(keys+ ", ");
        }
        System.out.println();
        System.out.print("Values present: ");
        for(List<String>  values : m.values()) {
            System.out.print(values + ", ");
        }
        System.out.println();
        for(Map.Entry<Integer, List<String>> entry : m.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Map<Integer, Integer> treeMap= new TreeMap<>();
        List<Integer> numList = new ArrayList<>(Arrays.asList(1,1,3,5,5,6,6,7,8,8,9));
        for(int it : numList) {
            if(!treeMap.containsKey(it)) {
                treeMap.put(it,0);
            }
            treeMap.put(it , treeMap.get(it)+1);
        }
        for(Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        System.out.println();
        int lowest = ((TreeMap<Integer, Integer>) treeMap).firstKey();
        int highest = ((TreeMap<Integer, Integer>) treeMap).lastKey();
//        higherKey() , lowerKey()
        System.out.println(lowest + ", " + highest);

    }
}
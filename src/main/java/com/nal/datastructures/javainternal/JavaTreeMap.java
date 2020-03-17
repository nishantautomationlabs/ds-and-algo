package com.nal.datastructures.javainternal;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by nishant on 06/03/20.
 */
public class JavaTreeMap {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        System.out.println("Put: " + map.put(1, 2));
        System.out.println("Put when already existing: " + map.put(1, 3));
        System.out.println("Replace: " + map.replace(1, 4));
        System.out.println("Replace when not found: " + map.replace(2, 1));
        map.put(2, map.getOrDefault(2, 0) + 5);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);

        System.out.println("First Key: " + map.firstKey());

        Map.Entry<Integer, Integer> entry = map.firstEntry();
        System.out.println(entry.getKey() + ":" + entry.getValue());

        System.out.println("Contains Key: " + map.containsKey(2));
        System.out.println("Contains Value: " + map.containsValue(5));
        System.out.println("Size: " + map.size());
        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());

        System.out.println("First Key: " + map.firstKey());
        System.out.println("Last Key: " + map.lastKey());
        System.out.println("First Entry: " + map.firstEntry().getKey() + ":" + map.firstEntry().getValue());
        System.out.println("Last Entry: " + map.lastEntry().getKey() + ":" + map.firstEntry().getValue());
//        map.firstEntry().setValue(1); //not supported

        System.out.println("Ceiling Key 3: " + map.ceilingKey(3));
        System.out.println("Higher Key 3: " + map.higherKey(3));
        System.out.println("Ceiling Entry 3: " + map.ceilingEntry(3));
        System.out.println("Higher Entry 3: " + map.higherEntry(3));

        System.out.println("Floor Key 3: " + map.floorKey(3));
        System.out.println("Lower Key 3: " + map.lowerKey(3));
        System.out.println("Floor Entry 3: " + map.floorEntry(3));
        System.out.println("Lower Entry 3: " + map.higherEntry(3));

        //not present
        System.out.println("Ceiling Key 8: " + map.ceilingKey(8));
        System.out.println("Ceiling Entry 8: " + map.ceilingEntry(8));

        //not present
        System.out.println("Floor Key 0: " + map.floorKey(0));
        System.out.println("Floor Entry 0: " + map.floorEntry(0));

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        SortedMap<Integer, Integer> subMap = map.subMap(4, 6); //4 inclusive 6 exclusive
        SortedMap<Integer, Integer> tailMap = map.tailMap(4);
        map.remove(1);
        map.clear();

    }
}

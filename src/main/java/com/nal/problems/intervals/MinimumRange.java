package com.nal.problems.intervals;

import com.nal.datastructures.trees.TreeNode;

import java.util.*;

/**
 * Created by nishant on 27/02/20.
 * An array, A = [ (1, 10), (2, 7), (3, 11), (4, 7)]
 * Another array B = [ 3, 4, 1, 10, 6, ..... ] (size of B >> A).
 * You need to find a range from A for each element of B that fits the element of B and the range is minimum.
 * For example, for the first element of B (which is 3), there are 2 ranges that fit which are (1, 10) and (2,7).
 * [Note that, ranges are exclusive, not inclusive, that's why (3,11) is not a fit for 3]
 */
public class MinimumRange {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(1, 10));
        intervals.add(new Interval(2, 9));
        intervals.add(new Interval(7, 11));
        intervals.add(new Interval(14, 19));
        intervals.add(new Interval(17, 23));

        List<Integer> integerList = new ArrayList<>(Arrays.asList(3, 5, 8, 12, 21, 28));
        List<Interval> result = findMinimumRange(intervals, integerList);
        result.stream().forEach(s -> System.out.println("[" + s.start + " " + s.end + "]"));
        System.out.println("---------------------------------");
    }

    private static List<Interval> findMinimumRange(List<Interval> intervals, List<Integer> integerList) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, Comparator.comparingInt(s -> s.end - s.start));
        for (Integer val : integerList) {
            for (Interval interval : intervals) {
                if (interval.start < val && interval.end > val) {
                    result.add(interval);
                    break;
                }
            }
        }
        return result;
    }
//
//    private static List<Interval> findMinimumRange2(List<Interval> intervals, List<Integer> integerList) {
//        List<Interval> result = new ArrayList<>();
//        Collections.sort(intervals, Comparator.comparingInt(s -> s.start));
//        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(s -> s.end - s.start));
//        TreeMap<Integer, Interval> map = new TreeMap<>();
//        for (Interval interval : intervals) {
//            priorityQueue.add(interval);
//            Interval peek = priorityQueue.peek();
//            map.put(interval.start + 1, peek);
//        }
//        int coveredTill = 0;
//        while (!priorityQueue.isEmpty()) {
//            Interval top = priorityQueue.poll();
//            if (top.end > coveredTill) {
//                coveredTill = top.end;
//                map.put(top.end - 1, top);
//            }
//        }
//        for (Integer val : integerList) {
//            if (map.ceilingKey(val) != null) {
//                System.out.println(val + ":" + map.ceilingKey(val));
//                result.add(map.get(map.ceilingKey(val)));
//            } else
//                result.add(new Interval(-1, -1));
//        }
//        return result;
//    }

}

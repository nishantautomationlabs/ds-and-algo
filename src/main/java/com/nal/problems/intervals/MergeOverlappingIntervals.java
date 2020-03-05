package com.nal.problems.intervals;

import java.util.*;

/**
 * Created by nishant on 26/02/20.
 * Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should
 * have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity.
 * For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals {1,3} and {2,4}
 * overlap with each other, so they should be merged and become {1, 4}. Similarly {5, 7} and {6, 8} should be merged
 * and become {5, 8}
 */
public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(6, 8));
        intervals.add(new Interval(4, 7));
        intervals.add(new Interval(1, 9));
        intervals.add(new Interval(11, 13));
        intervals.add(new Interval(15, 19));
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(5, 8));
        List<Interval> mergedList = mergeIntervals(intervals);
        mergedList.stream().forEach(s -> System.out.println("[" + s.start + " " + s.end + "]"));
        System.out.println("----------------------------------------------------");
        mergedList = mergeIntervals2(intervals);
        mergedList.stream().forEach(s -> System.out.println("[" + s.start + " " + s.end + "]"));
    }

    private static List<Interval> mergeIntervals(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(s -> s.start));
        int index = 0;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= intervals.get(index).end) {
                intervals.get(index).end = Math.max(intervals.get(index).end, intervals.get(i).end);
            }
            else {
                index++;
                intervals.set(index, intervals.get(i));
            }
        }
        return intervals.subList(0, index + 1);
    }

    private static List<Interval> mergeIntervals2(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(s -> s.start));
        Stack<Interval> stack = new Stack<>();
        stack.push(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= stack.peek().end) {
                Interval interval = stack.pop();
                interval.end = Math.max(interval.end, intervals.get(i).end);
                stack.push(interval);
            }
            else
                stack.push(intervals.get(i));
        }
        return new ArrayList<>(stack);
    }
}

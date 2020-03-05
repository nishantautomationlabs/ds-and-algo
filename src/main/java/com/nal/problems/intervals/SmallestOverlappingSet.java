package com.nal.problems.intervals;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by nishant on 26/02/20.
 * There are multiple intervals which may or may overlap with each other. Find a minimum subset of the intervals,
 * so that for every interval that is not included in the subset, it will find at least 1 interval in the subset
 * that will overlap with it.
 * Consider intervals: [0,2], [1,4], [3,10], [5, 6], [7,8], [9, 10].
 * A minimum subset should have 2 intervals: [3, 10] plus either [0, 2] or [1, 4].
 *
 * Solution: Find the job x in A which has the minimal end time (t).
 * From all jobs whose start time is less than t: pick the job j with the maximum end time.
 * Add j to the output set.
 * Remove all jobs which overlap j from A.
 * Repeat 1-4 until A is empty.
 */
public class SmallestOverlappingSet {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 2));
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(3, 10));
        intervals.add(new Interval(5, 6));
        intervals.add(new Interval(7, 8));
        intervals.add(new Interval(9, 10));
        List<Interval> overlappingSet = smallestOverlappingSet(intervals);
        overlappingSet.stream().forEach(s -> System.out.println("[" + s.start + " " + s.end + "]"));
    }

    private static List<Interval> smallestOverlappingSet(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, Comparator.comparingInt(s -> s.end));

        List<Interval> originalIntervals = new ArrayList<>(intervals);
        while (!intervals.isEmpty()) {
            Interval interval = intervals.get(0);
            Optional<Interval> max = originalIntervals.stream().filter(s -> s.start < interval.end).max(Comparator.comparingInt(o -> o.end));
            if (max.isPresent()) {
                Interval largest = max.get();
                result.add(largest);
                List<Interval> collect = intervals.stream().filter(s -> s.start < largest.end && s.end > largest.start).collect(Collectors.toList());
                intervals.removeAll(collect);
            } else {
                System.out.println("This should never happen");
            }
        }

        return result;
    }
}

Q} Non-overlapping Intervals
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.


import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int end = Integer.MIN_VALUE, remove = 0;

        for (int[] i : intervals) {
            if (i[0] < end) remove++;
            else end = i[1];
        }

        return remove;
    }
}
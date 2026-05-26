Q} merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.


import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        for (int[] i : intervals) {
            if (res.isEmpty() || res.get(res.size() - 1)[1] < i[0]) {
                res.add(i);
            } else {
                res.get(res.size() - 1)[1] =
                    Math.max(res.get(res.size() - 1)[1], i[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
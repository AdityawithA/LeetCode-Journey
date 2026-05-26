Q} Capacity To Ship Package Within D Days
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.



class Solution {
    
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        // Find search space
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        // Binary Search
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int currentWeight = 0;
        int requiredDays = 1;

        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                requiredDays++;
                currentWeight = 0;
            }

            currentWeight += weight;
        }

        return requiredDays <= days;
    }
}
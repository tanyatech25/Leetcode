class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long)1e16;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (canReduce(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReduce(long time, int mountainHeight, int[] workerTimes) {
        long total = 0;

        for (int wt : workerTimes) {
            long h = (long)(Math.sqrt((2.0 * time) / wt + 0.25) - 0.5);
            total += h;

            if (total >= mountainHeight) return true;
        }

        return total >= mountainHeight;
    }
}
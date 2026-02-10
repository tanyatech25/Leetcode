class Solution {
    public int[] shuffle(int[] nums, int n) {

        int[] ans = new int[2 * n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            ans[index] = nums[i];       // x_i
            ans[index + 1] = nums[i + n]; // y_i
            index += 2;
        }

        return ans;
    }
}

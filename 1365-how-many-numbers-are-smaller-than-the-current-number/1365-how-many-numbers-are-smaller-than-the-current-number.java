class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];

        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 1; i < 101; i++) {
            freq[i] += freq[i - 1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = (nums[i] == 0) ? 0 : freq[nums[i] - 1];
        }
        return ans;
    }
}
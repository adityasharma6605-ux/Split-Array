
class Solution {
    private boolean isPossible(int[] nums, int k, int mid) {
        int day = 1;
        int weight = 0;

        for (int w : nums) {
            if (w > mid) {
                return false;
            }

            weight += w;

            if (weight > mid) {
                day++;
                weight = w;
            }
        }

        return day <= k;
    }

    public int splitArray(int[] nums, int k) {
        int minsplit = 0;
        int maxsplit = 0;

        for (int num : nums) {
            minsplit = Math.max(minsplit, num);
            maxsplit += num;
        }

        while (minsplit <= maxsplit) {
            int mid = minsplit + (maxsplit - minsplit) / 2;

            if (isPossible(nums, k, mid)) {
                maxsplit = mid - 1;
            } else {
                minsplit = mid + 1;
            }
        }

        return minsplit;
    }
}

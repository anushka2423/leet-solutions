class Solution {
    public int minOperations(int[] nums, int k) {
        int[] ans1 = new int[k];
        int[] ans2 = new int[k];
        int c1 = 0, c2 = 0;

        for(int i = 0; i < k; i++) {
            c1 = 0;
            c2 = 0;
            for(int j = 0; j < nums.length; j++) {
                int val = nums[j]%k;

                if(j%2 == 0)
                    c1 += Math.min(Math.abs(val-i), k-Math.abs(val-i));
                else
                    c2 += Math.min(Math.abs(val-i), k-Math.abs(val-i));
            }

            ans1[i] = c1;
            ans2[i] = c2;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++) {
                if(i != j) {
                    ans = Math.min(ans, ans1[i]+ans2[j]);
                }
            }
        }

        return ans;
    }
}
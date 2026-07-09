class Solution {
    int MOD = 1000000007;
    public int divisibleGame(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.add(2);

        for(int i = 0; i < nums.length; i++) {
            findFactor(nums[i], set);
        }

        Iterator<Integer> iterator = set.iterator();

        int minK = 0, maxDiff = Integer.MIN_VALUE;
        while(iterator.hasNext()) {
            int[] arr = nums.clone();
            int k = iterator.next();
            for(int i = 0; i < arr.length; i++) {
                if(arr[i]%k != 0) arr[i] = -arr[i]; 
            }

            int max = maxSum(arr);
            if(maxDiff <= max) {
                if(maxDiff == max) minK = Math.min(k, minK);
                else minK = k;
                maxDiff = max;
            }
        }

        long ans = ((long) (minK%MOD) * (maxDiff%MOD))%MOD;

        return (int) (ans < 0 ? ans + MOD : ans);
    }

    private void findFactor(int num, Set<Integer> set) {
        int i = 2;

        while(i * i <= num) {
            if(num%i == 0) {
                set.add(i);
                set.add(num/i);
            }

            i++;
        }

        if(num > 1) set.add(num);
    }

    private int maxSum(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);

            if(sum <= 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
}

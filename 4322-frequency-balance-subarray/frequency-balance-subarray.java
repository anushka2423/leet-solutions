class Solution {
    public int getLength(int[] nums) {
        if(nums.length == 1) return 1;

        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Integer, Integer> count = new HashMap<>();
            for(int j = i; j < nums.length; j++) {
                int currNum = nums[j];
                int oldFre = map.getOrDefault(currNum, 0);
                int newFre = oldFre+1;
                map.put(currNum, newFre);

                if(oldFre > 0) {
                    int oldFreCount = count.get(oldFre);
                    if(oldFreCount == 1) {
                        count.remove(oldFre);
                    }else {
                        count.put(oldFre, oldFreCount-1);
                    }
                }

                count.put(newFre, count.getOrDefault(newFre, 0)+1);

                if(count.size() == 1 && map.size() == 1) {
                    maxLen = Math.max(maxLen, j-i+1);
                }else if(count.size() == 2) {
                    var iterator = count.keySet().iterator();
                    int key1 = iterator.next();
                    int key2 = iterator.next();

                    if (key1 == 2 * key2 || key2 == 2 * key1) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    }
                }
            }
        }

        return maxLen;
    }
}
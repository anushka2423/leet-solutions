class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, start = 0;

        for(int i = 0; i < fruits.length; i++) {
            if(!map.containsKey(fruits[i]) && map.size() == 2) {
                Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

                Map.Entry<Integer, Integer> e1 = it.next();
                Map.Entry<Integer, Integer> e2 = it.next();

                start = Math.min(e1.getValue(), e2.getValue())+1;

                if(e1.getValue() > e2.getValue()) map.remove(e2.getKey());
                else map.remove(e1.getKey());
            }

            map.put(fruits[i], i);
            maxLen = Math.max(maxLen, i-start+1);
        }

        return maxLen;
    }
}
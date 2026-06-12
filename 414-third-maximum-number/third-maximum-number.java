class Solution {
    public int thirdMax(int[] nums) {
        Long firstMax = null, secondMax = null, thirdMax = null;

        for(int eles : nums) {
            long ele = eles;
            if ((firstMax != null && firstMax == ele) ||
                (secondMax != null && secondMax == ele) ||
                (thirdMax != null && thirdMax == ele)) {
                continue;
            }
            if(firstMax == null || ele > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = ele;
            }
            else if(secondMax == null || ele > secondMax && ele < firstMax) {
                thirdMax = secondMax;
                secondMax = ele;
            }
            else if(thirdMax == null || ele > thirdMax && ele < secondMax) thirdMax = ele;
        }

        return thirdMax == null ? firstMax.intValue() : thirdMax.intValue();
    }
}
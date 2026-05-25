class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int less = 0;
        int high = people.length-1;

        while(less <= high) {
            if(people[less]+people[high] <= limit) {
                high--;
                less++;
            }else {
                high--;
            }

            boats++;
        }

        return boats;
    }
}
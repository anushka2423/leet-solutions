class Solution {
    public int maximumSwap(int num) {
        String nums = String.valueOf(num);

        for(int start = 0; start < nums.length(); start++) {
            char curr = nums.charAt(start);
            int largest = curr-'0';
            int larInd = start;
            System.out.println(largest+"anushka");
            for(int end = start+1; end < nums.length(); end++) {
                if(largest <= (nums.charAt(end)-'0') && (nums.charAt(end)-'0') != curr-'0') {
                    largest = nums.charAt(end)-'0';
                    larInd = end;
                }
            }

            if(larInd != start) {
                System.out.println(larInd+"anushka"+start);
                char[] ch = nums.toCharArray();
                char temp = ch[larInd];
                ch[larInd] = ch[start];
                ch[start] = temp;

                return Integer.valueOf(new String(ch));
            }
        }

        return num;
    }
}
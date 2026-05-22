class Solution {
    public int integerReplacement(int n) {
        int len = 0;
        long num = n;
        while(num != 1) {
            if(num%2 == 0) num /= 2;
            else{
                if(((num-1)/2)%2 != 0 && ((num+1)/2)%2 != 0) num -= 1;
                if(((num-1)/2)%2 == 0 || (num-1)/2 == 1)
                    num -= 1;
                else
                    num += 1;
            }

            len++;
        }

        return len;
    }
}
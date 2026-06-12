class Solution {
    public int addDigits(int num) {
        int sum = num;
        while(num%10 != num) {
            sum = 0;
            int temp = num;
            System.out.println(num);
            while(temp != 0) {
                sum += temp%10;
                temp = temp/10;
            }
            num = sum;
        }

        return sum;
    }
}
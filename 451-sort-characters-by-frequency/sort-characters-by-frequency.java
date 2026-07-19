class Solution {
    public String frequencySort(String s) {
        int[][] charc = new int[62][2];

        for(int i = 0; i < 62; i++) {
            charc[i][0] = i;
        }

        for(char ch : s.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                charc[ch-'a'][1]++;
            }else if(ch >= 'A' && ch <= 'Z'){
                charc[ch-'A'+26][1]++;
            }else {
                charc[ch-'0'+52][1]++;
            }
        }

        Arrays.sort(charc, Comparator.comparingInt((int[] row) -> row[1]).reversed());

        int i = 0;
        StringBuilder sb = new StringBuilder();
        char curr;

        while(i < 62 && charc[i][1] != 0) {
            while(charc[i][1] != 0) {
                curr = 'a';
                if (charc[i][0] >= 0 && charc[i][0] < 26) {
                    curr = (char) ('a' + charc[i][0]);
                } else if (charc[i][0] >= 26 && charc[i][0] < 52) {
                    curr = (char) ('A' + (charc[i][0] - 26));
                }else {
                    curr = (char) ('0' + (charc[i][0] - 52));
                }
                sb.append(curr);
                charc[i][1]--;
            }
            i++;
        }

        return sb.toString();
    }
}
class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> answer = new ArrayList<>();

        solve(n, k, answer, new StringBuilder(), 0);
        return answer;
    }

    private void solve(int n, int k, List<String> answer, StringBuilder s, int sum) {
        if(sum > k) return;
        if(s.length() == n) {
            answer.add(s.toString());
            return;
        }

        if(s.length() > 0 && s.charAt(s.length()-1) == '1') {
            s.append('0');
            solve(n, k, answer, s, sum);
            s.deleteCharAt(s.length() - 1);
        }else {
            s.append('1');
            solve(n, k, answer, s, sum+s.length()-1);
            s.deleteCharAt(s.length()-1);

            s.append('0');
            solve(n, k, answer, s, sum);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
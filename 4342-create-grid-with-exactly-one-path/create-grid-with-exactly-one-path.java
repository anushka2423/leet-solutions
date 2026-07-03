class Solution {
    public String[] createGrid(int m, int n) {
        String[] openPath = new String[m];

        for(int i = 0; i < m-1; i++) {
            StringBuilder s = new StringBuilder(".");
            for(int j = 1; j < n; j++) {
                s.append("#");
            }

            openPath[i] = s.toString();
        }

        StringBuilder s = new StringBuilder(".");
        for(int i = 1; i < n; i++) {
            s.append(".");
        }

        openPath[m-1] = s.toString();

        return openPath;
    }
}
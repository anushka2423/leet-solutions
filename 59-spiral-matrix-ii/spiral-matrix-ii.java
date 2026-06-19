class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        if (n == 0) return mat;

        int rlast = n-1, clast = n-1;
        int rstart = 0, cstart = 0;
        int ind = 1;

        while(rstart <= rlast && cstart <= clast) {
            for (int col = cstart; col <= clast; col++) {
                mat[rstart][col] = ind++;
            }
            rstart++;

            for (int row = rstart; row <= rlast; row++) {
                mat[row][clast] = ind++;
            }
            clast--;

            if (rstart <= rlast) {
                for (int col = clast; col >= cstart; col--) {
                    mat[rlast][col] = ind++;
                }
                rlast--;
            }

            if (cstart <= clast) {
                for (int row = rlast; row >= rstart; row--) {
                    mat[row][cstart] = ind++;
                }
                cstart++;
            }
        }

        return mat;
    }
}
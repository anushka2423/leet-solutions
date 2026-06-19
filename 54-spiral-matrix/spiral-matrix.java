class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;

        int rlast = matrix.length-1, clast = matrix[0].length-1;
        int rstart = 0, cstart = 0;

        while(rstart <= rlast && cstart <= clast) {
            for (int col = cstart; col <= clast; col++) {
                list.add(matrix[rstart][col]);
            }
            rstart++;

            for (int row = rstart; row <= rlast; row++) {
                list.add(matrix[row][clast]);
            }
            clast--;

            if (rstart <= rlast) {
                for (int col = clast; col >= cstart; col--) {
                    list.add(matrix[rlast][col]);
                }
                rlast--;
            }

            if (cstart <= clast) {
                for (int row = rlast; row >= rstart; row--) {
                    list.add(matrix[row][cstart]);
                }
                cstart++;
            }
        }

        return list;
    }
}
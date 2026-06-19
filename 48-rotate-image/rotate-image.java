class Solution {
    public void rotate(int[][] matrix) {
        int[][] rotated = new int[matrix.length][matrix[0].length];

        int rrow = 0, rcol = matrix[0].length-1;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.println(rrow+" "+rcol);
                rotated[rrow][rcol] = matrix[i][j];
                rrow++;
            }
            rrow = 0;
            rcol--;
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int count = -1;
        int freshCount = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    freshCount++;
                }

                if(grid[i][j] == 2)
                    queue.add(new int[]{i, j});
            }
        }

        if(freshCount == 0) return 0;
        if(queue.isEmpty()) return -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] ro = queue.poll();

                for(int i = 0; i < 4; i++) {
                    int nr = ro[0]+dr[i];
                    int nc = ro[1]+dc[i];

                    if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

                    if(grid[nr][nc] != 1) continue;

                    grid[nr][nc] = 2;
                    freshCount--;
                    queue.add(new int[]{nr, nc});
                } 
            }
            count++;
        }

        if(freshCount > 0) return -1;

        return count;
    }
}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];

            map.computeIfAbsent(pre, k -> new ArrayList<>()).add(course);
            indegree[course]++;
        }

        return checkForTopological(map, numCourses, indegree);
    }

    private boolean checkForTopological(Map<Integer, List<Integer>> map, int n, int[] indegree) {
        int count = 0;
        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0){
                count++;
                que.offer(i);
            }
        }

        while(!que.isEmpty()) {
            int peek = que.poll();
            List<Integer> list = map.get(peek);

            if(list == null || list.size() == 0) continue;

            for(int neighbor : list) {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    count++;
                    que.offer(neighbor);
                }
            }
        }

        return count == n;
    }
}
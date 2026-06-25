class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] answer = new int[numCourses];
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];

            map.computeIfAbsent(pre, k -> new ArrayList<>()).add(course);
            indegree[course]++;
        }

        return topologicalSort(map, indegree, numCourses, answer);
    }

    private int[] topologicalSort(Map<Integer, List<Integer>> map, int[] indegree, int n, int[] answer) {

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int ind = 0;

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                count++;
                answer[ind++] = i;
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int root = queue.poll();
            List<Integer> list = map.get(root);

            if(list == null || list.size() == 0) continue;

            for(int neighbor : list) {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    count++;
                    answer[ind++] = neighbor;
                    queue.offer(neighbor);
                }
            }
        }

        return count == n ? answer : new int[]{};
    }
}
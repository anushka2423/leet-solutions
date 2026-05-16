class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        if(rooms.get(0).size() < 1) return false;

        for(int i = 0; i < rooms.get(0).size(); i++) {
            set.add(rooms.get(0).get(i));
        }
        visited.add(0);

        while(!set.isEmpty()) {
            int key = set.iterator().next();
            if(visited.contains(key)){
                set.remove(key);
                continue;
            }

            List<Integer> room = rooms.get(key);

            visited.add(key);
            set.remove(key);

            for(int i = 0; i < room.size(); i++) {
                set.add(room.get(i));
            }
        }

        System.out.println(visited);

        return visited.size() >= rooms.size();
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Map<String, Double>>> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        double[] ans = new double[queries.size()];

        for(int i = 0; i < equations.size(); i++) {
            map.computeIfAbsent(equations.get(i).get(0), k -> new ArrayList<>()).add(new HashMap<>(Map.of(equations.get(i).get(1), values[i])));

            map.computeIfAbsent(equations.get(i).get(1), k -> new ArrayList<>()).add(new HashMap<>(Map.of(equations.get(i).get(0), 1/values[i])));
        }

        for(int i = 0; i < queries.size(); i++) {
            set.clear();
            set.add(queries.get(i).get(0));
            if(!map.containsKey(queries.get(i).get(0)) || !map.containsKey(queries.get(i).get(1))) {
                ans[i] = -1.0;
                continue;
            }
            ans[i] = solve(queries.get(i).get(0), queries.get(i).get(1), set, map, 1);
        }

        return ans;
    }

    private double solve(String source, String destination, Set<String> set, Map<String, List<Map<String, Double>>> map, double currProd) {
        if(source.equals(destination)) return currProd;

        List<Map<String, Double>> list = map.get(source);
        
        for(int i = 0; i < list.size(); i++) {
            Map<String, Double> submap = list.get(i);

            Map.Entry<String, Double> entry = submap.entrySet().iterator().next();
            String neighbor = entry.getKey();
            double edgeWeight = entry.getValue();
            
            if(set.contains(neighbor)) continue;

            set.add(neighbor);
            double ans = solve(neighbor, destination, set, map, currProd*edgeWeight);
            set.remove(neighbor);

            if(ans != -1) return ans;
        }

        return -1.0;
    }
}
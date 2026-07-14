class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder s = new StringBuilder();

        for(String ele : chunks) {
            s.append(ele);
        }

        String[] arr = s.toString().split(" ");
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            String ele = arr[i];
            if(ele.contains("-")) {
                StringBuilder news = new StringBuilder();
                if(ele.charAt(0) != '-') news.append(ele.charAt(0));

                for(int j = 1; j < ele.length()-1; j++) {
                    if(ele.charAt(j) == '-') {
                        if(ele.charAt(j-1) == '-' || ele.charAt(j+1) == '-') {
                            if(news.length() != 0) 
                                map.put(news.toString(), map.getOrDefault(news.toString(), 0)+1);

                            news = new StringBuilder();
                        }else {
                            news.append(ele.charAt(j));
                        }
                    }else {
                        news.append(ele.charAt(j));
                    }
                }

                if(ele.charAt(ele.length()-1) != '-') news.append(ele.charAt(ele.length()-1));
                System.out.println(news); 

                if(news.length() != 0) 
                    map.put(news.toString(), map.getOrDefault(news.toString(), 0)+1);

            }else {
                map.put(ele, map.getOrDefault(ele, 0)+1);
            }
        }

        System.out.println(map); 

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            if(map.containsKey(queries[i])) {
                ans[i] = map.get(queries[i]);
            }else {
                ans[i] = 0;
            }
        }

        return ans;
    }
}

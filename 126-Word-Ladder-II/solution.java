public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> set) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(endWord);
        ladderLength(beginWord, endWord, set, map);
        dfs(result, path, endWord, beginWord, map);
        return result;
    }
    void dfs(List<List<String>> result, List<String> path, String endWord, String beginWord, Map<String, List<String>> map){
        if (endWord.equals(beginWord)) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (String temp : map.get(endWord)) {
            path.add(0, temp);
            dfs(result, path, temp, beginWord, map);
            path.remove(0);
        }
        
    }
    void ladderLength(String beginWord, String endWord, Set<String> set, Map<String, List<String>> map) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        set.remove(beginWord);
        for (String key : set) {
            map.put(key, new ArrayList<>());
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(queue);
            Set<String> row = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                List<String> nbs = getNbs(s, set);
                for (String str : nbs) {
                    map.get(str).add(s);
                    if (!row.contains(str)){
                        queue.add(str);
                        row.add(str);
                    }
                }
            }
            set.removeAll(row);
        }
    }
    
    List<String> getNbs(String word, Set<String> set) {
        List<String> list = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = word.charAt(i);
            for (char a = 'a'; a <= 'z'; a++) {
                if (a == c) {
                    continue;
                }
                chars[i] = a;
                String temp = new String(new String(chars));
                if (set.contains(temp)) {
                    list.add(temp);
                }
            }
            chars[i] = c;
        }
        return list;
    }
}

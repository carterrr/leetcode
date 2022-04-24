class Solution {

    // 难点是边界问题理清  String#substring() 方法 endIndex参数可以是 length  比实际坐标大
    public List<Integer> findSubstring(String s, String[] words) {
        int step = words[0].length();
        int size = words.length;
        int window = step * size;
        int sLen = s.length();
        List<Integer> res = new ArrayList<>();
        if(window > sLen) return res;
        Map<String, Integer> target = new HashMap<>();
        for(String w : words) {
            target.put(w, target.getOrDefault(w, 0) + 1);
        }
        Map<String, Integer> wordInWin = new HashMap<>();
        int l = 0, r = 0;
        // 初始化窗口
        while(r < window)  {
            String word = s.substring(r , r + step);
            wordInWin.put(word, wordInWin.getOrDefault(word, 0) + 1);
            r += step;
        }
        if(match(wordInWin, target)) res.add(l); // 添加完成先判断一次

        // 同步移动 看窗口是否满足
        while(r < sLen) { // 左闭右开 r不可达  因此r可到最大 + 1  仅仅作为不可达边界
            wordInWin = new HashMap<>();
            l ++;
            r ++;
            int tmp = l;
            while(tmp < r) {
                String w = s.substring(tmp, tmp + step);
                wordInWin.put(w, wordInWin.getOrDefault(w, 0) + 1);
                tmp += step;
            }
            if(match(wordInWin, target)) res.add(l); // 每次移动完判断一次
        }

        return res;
    }

    private boolean match(Map<String, Integer> window, Map<String, Integer> target) {
        for(String word : target.keySet()) {
            if(!target.get(word).equals(window.get(word)) ) return false;
        }
        return true;
    }
}
class Solution {
        List<List<Integer>> res = new ArrayList<>();
List<Integer> tmp = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        bt(candidates, target, 0);
        return res;
    }

    public void bt( int[] candidates, int remain, int fromIdx) {
        if(remain < 0 ) return;
        if(remain == 0) { res.add(new ArrayList<>(tmp));  return;}
        for(int i = fromIdx; i< candidates.length; i++) {
            tmp.add(candidates[i]);
            bt( candidates, remain - candidates[i], i);
            tmp.remove(tmp.size() - 1); // 重点  全局就一个tmp即可  每次从里面新增或者尾部删除 不用清空
        }
    }
}
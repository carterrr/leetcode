class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = (int)Math.pow(2, nums.length) - 1; i >=0; i--) {
            List<Integer> tmp = new ArrayList<>();
            int j = 0;
            int cur = 1;
            while(cur <= i) {
                if((cur & i) != 0) {
                    tmp.add(nums[j]);
                }
                j++;
                cur = cur << 1;
            }
            res.add(tmp);
        }
        return res;
    }
}
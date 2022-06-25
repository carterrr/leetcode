class Solution {
    public int lastStoneWeight(int[] stones) {
        MaxHeap maxHeap = new MaxHeap(stones);
        while(maxHeap.size() >= 2) {
            int x = maxHeap.pop();
            int y = maxHeap.pop();
            if(x > y) maxHeap.push(x - y);
        }
        return maxHeap.size() == 1 ? maxHeap.pop() : 0;
    }

    static class MaxHeap{
        int[] data;
        int remain;

        public MaxHeap(int[] data){
            this.data = data;
            this.remain = data.length;
            for(int i = remain >> 1; i >= 0; i --) shiftDown(i);
        }


        private void shiftDown(int i) {
            int r = (i + 1) << 1;
            int l = r - 1;
            int max = i;
            if(r < remain && data[max] < data[r]) max = r;
            if(l < remain && data[max] < data[l]) max = l;
            if(max != i) {
                int tmp = data[max];
                data[max] = data[i];
                data[i] = tmp;
                shiftDown(max);
            }
        }

        private void shiftUp(int i) {
            if(i == 0 || i >= remain) return;
            int root = (i -1) >> 1;
            if(data[root] < data[i]){
                int tmp = data[root];
                data[root] = data[i];
                data[i] = tmp;
                shiftUp(root);
            }
        }

        public void push(int i){
            if(remain < data.length) {
                data[remain++] = i;
                shiftUp(remain - 1);
            }
           
        }

        public int pop() {
            if(isEmpty()) return -1;
            int res = data[0];
            data[0] = data[--remain];
            shiftDown(0);
            return res;
        }

        public boolean isEmpty() {
            return remain == 0;
        }

        public int size() {
            return remain;
        }
    }
}
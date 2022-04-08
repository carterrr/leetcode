package redo;

public class 设计一个增量操作的栈_1381{

}

class CustomStack {

    int[] data;
    int[] add;
    int maxSize;
    int curSize;

    public CustomStack(int maxSize) {
        data = new int[maxSize];
        add = new int[maxSize];
        this.maxSize = maxSize;
        this.curSize = 0;
    }
    
    public void push(int x) {
        if(curSize == maxSize){
            return;
        }
        data[curSize++] = x;
    }
    
    public int pop() {
        if(curSize == 0) return -1;
        int res = data[curSize - 1] + add[curSize - 1];
        if(curSize > 1) {
            add[curSize - 2] += add[curSize - 1]; 
        }
        add[curSize - 1] = 0;
        curSize--;
        return res;
    }
    
    public void increment(int k, int val) {
        if(curSize == 0) return;
        add[Math.min(k, curSize) - 1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
package redo;

import java.util.Deque;
import java.util.LinkedList;

public class 最小栈_155 {}
class MinStack {

    Deque<Integer> nStack;
    Deque<Integer> mStack; // 辅助栈法  栈底保存第一个元素   因此 在主栈不为空前不可能为空

    /** initialize your data structure here. */
    public MinStack() {
        nStack = new LinkedList<>();
        mStack = new LinkedList<>();
    }
    
    public void push(int x) {
        
        if(nStack.isEmpty() || x <= mStack.peek()) { // 注意等于的情况  不加等于可能导致提前弹出
            mStack.push(x);
        }
        nStack.push(x);
    }
    
    public void pop() {
        int x = nStack.pop();
        if(mStack.peek().equals(x)) {
            mStack.pop();
        }
    }
    
    public int top() {
        return nStack.peek();
    }
    
    public int min() {
        return mStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
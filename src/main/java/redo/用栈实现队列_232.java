public class 用栈实现队列_232{
    
}

class MyQueue {

    Deque<Integer> pushStack;
    Deque<Integer> popStack;

    public MyQueue() {
        pushStack = new LinkedList<>();
        popStack = new LinkedList<>();
    }
    
    public void push(int x) {
        pushStack.push(x);
    }
    
    public int pop() {
        if(popStack.isEmpty()){
            transfer();
        }
        if(popStack.isEmpty()) 
        return -1;
        return popStack.pop();
    }
    
    public int peek() {
        if(popStack.isEmpty()){
            transfer();
        }
        if(popStack.isEmpty()) 
        return -1;
        return popStack.peek();
    }
    
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    private void transfer() {
        while(!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }
}
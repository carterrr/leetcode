package redo;

import java.util.Deque;
import java.util.LinkedList;

public class 最多能完成的排序块_II_768{}
// 比前面块最大值大的数字成一块  如果出现小的 看是前面哪几个最大值和这个小的数字合并成一块
class Solution_ {
    public int maxChunksToSorted(int[] arr) {
       Deque<Integer> stack = new LinkedList<>();
       for(int i : arr) {
           if(!stack.isEmpty() && i < stack.peek()) {
               int top = stack.pop();
               while(!stack.isEmpty() && i < stack.peek())  {
                   stack.pop();
               }
               stack.push(top);
           } else {
               stack.push(i);
           }
       }
       return stack.size();
    }
}